/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License, version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.relationalai.util.http;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http2.Http2SecurityUtil;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.ApplicationProtocolConfig.Protocol;
import io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior;
import io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior;
import io.netty.handler.ssl.ApplicationProtocolNames;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.Optional;

import static io.netty.buffer.Unpooled.wrappedBuffer;
import io.netty.handler.codec.http.HttpMethod;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpMethod.PUT;
import static io.netty.handler.codec.http.HttpMethod.DELETE;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;

import org.conscrypt.Conscrypt;
import java.security.Security;
import javax.net.ssl.SSLException;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.signature.PublicKeySignFactory;
import com.google.crypto.tink.config.TinkConfig;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import com.relationalai.util.auth.ClientSideAuthenticationUtil;
import com.relationalai.util.FormattingUtil;
import com.relationalai.util.RaiLogger;
import com.relationalai.util.auth.NullKeysetException;
import com.relationalai.client.api.ClientConfig;

/**
 * An HTTP2 client that allows you to send HTTP2 frames to a server. Inbound and outbound frames are
 * logged. When run from the command-line, sends a single HEADERS frame to the server and gets back
 * a "Hello World" response.
 */
public final class Http2Client
{

    static final Logger LOGGER = RaiLogger.getLogger(MethodHandles.lookup().lookupClass());

/*
    static final boolean SSL = System.getProperty("ssl") != null;
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", SSL? "8443" : "8080"));
    static final String URL = System.getProperty("url", "/whatever");
    static final String URL2 = System.getProperty("url2");
    static final String URL2DATA = System.getProperty("url2data", "test data!");
*/

    private static SslContext configureSSL() throws SSLException
    {
        final SslContext sslCtx;

        // Use Concrypt as security provider
        Security.insertProviderAt(Conscrypt.newProvider(), 1);

        SslProvider provider = OpenSsl.isAlpnSupported() ? SslProvider.OPENSSL : SslProvider.JDK;
        sslCtx = SslContextBuilder.forClient()
                .sslProvider(provider)
                /* NOTE: the cipher filter may not include all ciphers required by the HTTP/2 specification.
                 * Please refer to the HTTP/2 specification for cipher requirements. */
                .ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE)
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .applicationProtocolConfig(new ApplicationProtocolConfig(
                    Protocol.ALPN,
                    // NO_ADVERTISE is currently the only mode supported by both OpenSsl and JDK providers.
                    SelectorFailureBehavior.NO_ADVERTISE,
                    // ACCEPT is currently the only mode supported by both OpenSsl and JDK providers.
                    SelectedListenerFailureBehavior.ACCEPT,
                    ApplicationProtocolNames.HTTP_2,
                    ApplicationProtocolNames.HTTP_1_1))
                .build();

        return sslCtx;
    }

    public static FullHttpResponse postUnsigned(String host, int port, String serviceUri, String payload, String serviceIdentifier, ClientConfig config)
        throws Exception
    {
        return sendPutPostDelete(POST, host, port, serviceUri, payload, serviceIdentifier, config, false);
    }

    public static FullHttpResponse postSigned(String host, int port, String serviceUri, String payload, String serviceIdentifier, ClientConfig config)
        throws Exception
    {
        return sendPutPostDelete(POST, host, port, serviceUri, payload, serviceIdentifier, config, true);
    }

    public static FullHttpResponse sendPutPostDelete(HttpMethod method,
        String host, int port,
        String serviceUri, String payload, String serviceIdentifier,
        ClientConfig config, boolean signed)
        throws Exception
    {
        LOGGER.debug("Http2Client.sendPutPostDelete: " + payload);

        FullHttpRequest request = new DefaultFullHttpRequest(HTTP_1_1, method, serviceUri,
            wrappedBuffer(payload.getBytes(CharsetUtil.UTF_8)));

        int streamId = 3;
        AsciiString hostName = new AsciiString(host + ':' + port);

        populatePutPostRequestHeaders(request, hostName, streamId);

        if ( signed )
        {
            signRequest(request, config.getAccessKey(), config.getRegionName(), config.getPrivateKeysetHandle(), serviceIdentifier);
        }

        return sendRequest(request, host, port, streamId);
    }

    public static FullHttpResponse putUnsigned(String host, int port, String serviceUri,
                                               String payload, String serviceIdentifier,
                                               ClientConfig config) throws Exception
    {
        return sendPutPostDelete(PUT, host, port, serviceUri, payload, serviceIdentifier, config, false);
    }

    public static FullHttpResponse putSigned(String host, int port, String serviceUri,
                                        String payload, String serviceIdentifier,
                                        ClientConfig config) throws Exception
    {
        return sendPutPostDelete(PUT, host, port, serviceUri, payload, serviceIdentifier, config, true);
    }

    public static FullHttpResponse deleteSigned(String host, int port, String serviceUri,
                                        String payload, String serviceIdentifier,
                                        ClientConfig config) throws Exception
    {
        return sendPutPostDelete(DELETE, host, port, serviceUri, payload, serviceIdentifier, config, true);
    }

    public static void signRequest(FullHttpRequest request, String accessKey, String regionName, KeysetHandle privateKeysetHandle, String serviceIdentifier)
        throws Exception, NullKeysetException
    {
        if ( privateKeysetHandle == null )
            throw new NullKeysetException("Private keyset is null. Cannot sign request. Please make sure you have the appropriate entries in your rai_config file");

        // Initialize tink
        // TODO : need to make sure this is only called once
        TinkConfig.register();

        // URL-encode serviceUri
        String stringToSign = ClientSideAuthenticationUtil.getStringToSign(request, accessKey, regionName, serviceIdentifier);

        LOGGER.debug(
            "Http2Client.signRequest: \n" +
            "accessKey=" + accessKey +
            "\nstringToSign=\n" +
            "*********************\n" +
            stringToSign +
            "\n****** End string-to-sign **** \n");

        // Create signature
        PublicKeySign signer = PublicKeySignFactory.getPrimitive(privateKeysetHandle);

        byte[] signature = signer.sign(stringToSign.getBytes());
        String hexSig = FormattingUtil.toHexString(signature).toLowerCase();

        LOGGER.debug(
            "***** Signature (HEX)**** \n" +
            hexSig +
            "\n***** End Signature ****");

        // make authorization header.
        String authHeader = ClientSideAuthenticationUtil.makeAuthorizationHeader(request, accessKey, regionName, serviceIdentifier, hexSig);

        // shoved it into the headers
        request.headers().add(HttpHeaderNames.AUTHORIZATION, authHeader);
    }

    public static String getResponseContent(FullHttpResponse response)
    {
        ByteBuf content = response.content();
        int contentLength = content.readableBytes();
        byte[] arr = new byte[contentLength];
        content.readBytes(arr);

        return new String(arr, 0, contentLength, CharsetUtil.UTF_8);
    }

/*
    public static FullHttpResponse get(String host, int port, String serviceUri) throws Exception
    {
        return get(host, port, serviceUri, Optional.empty() );
    }
*/
    /**
     * Default get uses SSL
     */
     /*
    public static FullHttpResponse get(String host, int port, String serviceUri, Optional<Map<String, String>> headers) throws Exception
    {
        return get(host, port, serviceUri, headers, true);
    }

    public static FullHttpResponse get(String host, int port, String serviceUri, Optional<Map<String, String>> headers, boolean ssl) throws Exception
    {
        // Create a simple GET request with a body.
        FullHttpRequest request = new DefaultFullHttpRequest(HTTP_1_1, GET, serviceUri);

        int streamId = 3;
        AsciiString hostName = new AsciiString(host + ':' + port);
        populateBasicRequestHeaders(request, hostName, streamId, ssl);

        if ( headers.isPresent())
        {
            populateAdditionalHeaders(request, headers.get());
        }

        if ( ssl )
        {
            return sendRequest(request, host, port, streamId);
        }
        else
        {
            return sendCleartextRequest(request, host, port, streamId);
        }
    }
*/

    public static FullHttpResponse sendGet(String host, int port,
        String serviceUri, String payload, String serviceIdentifier,
         Optional<Map<String, String>> headers, boolean ssl,
        ClientConfig config, boolean signed)
        throws Exception
    {
        FullHttpRequest request = new DefaultFullHttpRequest(HTTP_1_1, GET, serviceUri,
            wrappedBuffer(payload.getBytes(CharsetUtil.UTF_8)));

        int streamId = 3;
        AsciiString hostName = new AsciiString(host + ':' + port);

        populateBasicRequestHeaders(request, hostName, streamId, ssl);
        request.headers().add(HttpHeaderNames.CONTENT_TYPE, "application/json");

        if ( headers.isPresent())
        {
            populateAdditionalHeaders(request, headers.get());
        }

        if ( signed )
        {
            signRequest(request, config.getAccessKey(), config.getRegionName(), config.getPrivateKeysetHandle(), serviceIdentifier);
        }

        if ( ssl )
        {
            return sendRequest(request, host, port, streamId);
        }
        else
        {
            return sendCleartextRequest(request, host, port, streamId);
        }
    }

    public static FullHttpResponse sendCleartextRequest(FullHttpRequest request, String host, int port, int streamId) throws Exception
    {
        return sendRequestWithSslContext(null, request, host, port, streamId);
    }

    public static FullHttpResponse sendRequest(FullHttpRequest request, String host, int port, int streamId) throws Exception
    {
        final SslContext sslCtx = configureSSL();
        return sendRequestWithSslContext(sslCtx, request, host, port, streamId);
    }

    private static FullHttpResponse sendRequestWithSslContext(final SslContext sslCtx, FullHttpRequest request, String host, int port, int streamId)
        throws Exception
    {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Http2ClientInitializer initializer = new Http2ClientInitializer(sslCtx, Integer.MAX_VALUE);
        try
        {
            // Configure the client.
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.remoteAddress(host, port);
            b.handler(initializer);

            LOGGER.debug("Http2Client.sendRequestWithSslContext... starting client");

            // Start the client.
            Channel channel = b.connect().syncUninterruptibly().channel();

            // Wait for the HTTP/2 upgrade to occur.
            // What if I skip this....
            Http2SettingsHandler http2SettingsHandler = initializer.settingsHandler();
            try {
                http2SettingsHandler.awaitSettings(5, TimeUnit.SECONDS);
            }
            catch (Exception e)
            {
                LOGGER.error("Http2Client.sendRequestWithSslContext Exception caught. Continue: " + e.getMessage());
            }

            for ( Map.Entry<String, String> header : request.headers())
            {
                LOGGER.debug("Header " + header.getKey() + ", " + header.getValue());
            }

            HttpResponseHandler responseHandler = initializer.responseHandler();
            responseHandler.put(streamId, channel.write(request), channel.newPromise());
            channel.flush();
            responseHandler.awaitResponses(10, TimeUnit.MINUTES);

            LOGGER.debug("Http2Client.sendRequestWithSslContext.... awaitResponse done");

            // Wait until the connection is closed.
            channel.close().syncUninterruptibly();

            FullHttpResponse response = responseHandler.getHttpResponse(streamId);

            LOGGER.debug("Http2Client.sendRequestWithSslContenxt received response: " + response);
            for ( Map.Entry<String, String> header : response.headers() )
            {
                LOGGER.debug("****** Header key = " + header.getKey() + ", value = " + header.getValue());
            }
            return response;
        }
        finally
        {
            workerGroup.shutdownGracefully();
        }
    }

    public static void populatePutPostRequestHeaders(FullHttpRequest request, AsciiString hostName, int streamId)
    {
        populateBasicRequestHeaders(request, hostName, streamId);
        request.headers().add(HttpHeaderNames.CONTENT_TYPE, "application/json");
    }

    public static void populateBasicRequestHeaders(FullHttpRequest request, AsciiString hostName, int streamId)
    {
        populateBasicRequestHeaders(request, hostName, streamId, true);
    }

    public static void populateBasicRequestHeaders(FullHttpRequest request, AsciiString hostName, int streamId, boolean ssl)
    {
        request.headers().add(HttpHeaderNames.HOST, hostName);

        if ( ssl )
        {
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), HttpScheme.HTTPS.name());
        }
        else
        {
            request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), HttpScheme.HTTP.name());
        }

        request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);
        request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.DEFLATE);
        request.headers().add(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), streamId);
    }

    private static void populateAdditionalHeaders(FullHttpRequest request, Map<String, String> headers)
    {
        for ( Map.Entry<String, String> entry : headers.entrySet())
        {
            request.headers().add(entry.getKey(), entry.getValue());
        }
    }

    public static String prettyPrintJson(String jsonStr)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonStr);
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;
    }

/*
            if (URL != null) {
                // Create a simple GET request.
                FullHttpRequest request = new DefaultFullHttpRequest(HTTP_1_1, GET, URL);
                request.headers().add(HttpHeaderNames.HOST, hostName);
                request.headers().add(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), scheme.name());
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);
                request.headers().add(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.DEFLATE);
                request.headers().add(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), streamId);

                System.out.println("************ BEGIN Full Request " + URL + " ************* ");
                System.out.println(request.headers());
                System.out.println("************ END Full Request ************* ");
                responseHandler.put(streamId, channel.write(request), channel.newPromise());

                streamId += 2;
            }
            if (URL2 != null) {
            */
}

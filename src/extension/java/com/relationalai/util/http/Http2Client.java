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

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.signature.PublicKeySignFactory;
import com.relationalai.util.FormattingUtil;
import com.relationalai.util.InvalidRequestException;
import com.relationalai.util.RaiLogger;
import com.relationalai.util.auth.ClientSideAuthenticationUtil;
import com.relationalai.util.auth.NullKeysetException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.util.CharsetUtil;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.security.GeneralSecurityException;

/**
 * An HTTP2 client that allows you to send HTTP2 frames to a server. Inbound and outbound frames are
 * logged. When run from the command-line, sends a single HEADERS frame to the server and gets back
 * a "Hello World" response.
 */
public final class Http2Client
{

    static final Logger LOGGER = RaiLogger.getLogger(MethodHandles.lookup().lookupClass());

    public static void signRequest(Request request, String accessKey, String regionName, KeysetHandle privateKeysetHandle, String serviceIdentifier)
            throws NullKeysetException, GeneralSecurityException, InvalidRequestException, IOException {
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
        request.headers().newBuilder().add(HttpHeaderNames.AUTHORIZATION.toString(), authHeader);
    }

    public static String getResponseContent(Response response) throws IOException {
        byte[] arr = response.body().bytes();

        return new String(arr, 0, arr.length, CharsetUtil.UTF_8);
    }

}
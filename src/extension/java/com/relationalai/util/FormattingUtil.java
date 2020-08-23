package com.relationalai.util;

import java.text.SimpleDateFormat;
import java.security.SecureRandom;
import java.util.Base64;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.io.IOException;

public class FormattingUtil
{

    public static String prettyPrintJsonString(String jsonStr)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonStr);
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;
    }

    public static SimpleDateFormat getDateFormatter()
    {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    }

    public static String getRandomName(int bytes)
    {
    	SecureRandom rand = new SecureRandom();
    	byte[] randomBytes = new byte[4];
    	rand.nextBytes(randomBytes);
    	byte[] encoded = Base64.getEncoder().encode(randomBytes);

    	return toHexString(encoded);
    }

    public static String toHexString( byte[] bytes )
    {
        StringBuffer sb = new StringBuffer( bytes.length*2 );
        for( int i = 0; i < bytes.length; i++ )
        {
            sb.append( toHex(bytes[i] >> 4) );
            sb.append( toHex(bytes[i]) );
        }
        return sb.toString();
    }

    private static char toHex(int nibble)
    {
        final char[] hexDigit =
        {
            '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'
        };
        return hexDigit[nibble & 0xF];
    }

    private static int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if(digit == -1)
        {
            throw new IllegalArgumentException(
              "Invalid Hexadecimal Character: "+ hexChar);
        }
        return digit;
    }

    public static byte[] fromHexString(String hexString)
    {
        if (hexString.length() % 2 == 1)
        {
            throw new IllegalArgumentException(
                "Invalid hexadecimal String supplied.");
        }

        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2)
        {
            bytes[i / 2] = hexToByte(hexString.substring(i, i + 2));
        }
        return bytes;
    }

    public static byte hexToByte(String hexString)
    {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    public static String fileToString(File file) throws IOException
    {
    	StringBuilder builder = new StringBuilder();
    	Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8);
    	stream.forEach(s -> builder.append(s).append("\n"));

    	return builder.toString();
    }
}

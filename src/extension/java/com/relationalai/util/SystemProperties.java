package com.relationalai.util;

public class SystemProperties
{

    public static void setSystemProperties()
    {
        System.setProperty("com.sun.net.ssl.enableECC", "false");
    }

    public static void setSsl()
    {
        System.setProperty("ssl", "true");
    }

}

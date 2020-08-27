package com.relationalai.util;

import java.util.Map;
import java.util.HashMap;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class RaiLogger
{
    // TODO do more coarse-grained mapping of logger instances to class.
    private static final Map<Class,Logger> loggerMap = new HashMap<Class,Logger>();

    public static final Marker FATAL = MarkerFactory.getMarker("FATAL");

    public static Logger getLogger(Class clazz)
    {
        if ( loggerMap.containsKey(clazz) )
        {
            return loggerMap.get(clazz);
        }
        else
        {
            Logger logger = LoggerFactory.getLogger(clazz);
            loggerMap.put(clazz, logger);
            return logger;
        }
    }
}

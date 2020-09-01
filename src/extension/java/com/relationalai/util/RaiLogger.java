package com.relationalai.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.HashMap;
import java.util.Map;

public class RaiLogger {
    public static final Marker FATAL = MarkerFactory.getMarker("FATAL");
    // TODO do more coarse-grained mapping of logger instances to class.
    private static final Map<Class, Logger> loggerMap = new HashMap<Class, Logger>();

    public static Logger getLogger(Class clazz) {
        if (loggerMap.containsKey(clazz)) {
            return loggerMap.get(clazz);
        } else {
            Logger logger = LoggerFactory.getLogger(clazz);
            loggerMap.put(clazz, logger);
            return logger;
        }
    }
}

package com.triassic.pterovm.handlers;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private static final Logger logger = Logger.getLogger(Log.class.getName());

    private Log() {
        try {
            Handler fileHandler = new FileHandler("pterovm.log");
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        return logger;
    }

    public static void log(Level level, String msg) {
        logger.log(level, msg);
    }

    public static void severe(String msg) {
        logger.severe(msg);
    }

    public static void warning(String msg) {
        logger.warning(msg);
    }

    public static void info(String msg) {
        logger.info(msg);
    }
}
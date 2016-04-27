package com.ga.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class LoggerUtility.
 */
public class LoggerUtility {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtility.class);

    /**
     * Error.
     * 
     * @param serverCode the server code
     * @param message the message
     * @param ex the ex
     */
    public static void error(ServerCodes serverCode, String message, Throwable ex) {
        LOGGER.error(message, ex);
    }
}

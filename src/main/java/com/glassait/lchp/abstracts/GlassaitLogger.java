package com.glassait.lchp.abstracts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GlassaitLogger {
    private final Logger logger = LoggerFactory.getLogger(GlassaitLogger.class);

    /**
     * Log an error
     *
     * @param error The message of the error
     */
    protected void logError(String error) {
        this.logger.error("ERROR -> " + error);
    }

    /**
     * Log a debug
     *
     * @param message The debug message
     */
    protected void logDebug(String message) {
        this.logger.debug("DEBUG -> " + message);
    }
}

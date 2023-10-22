package com.glassait.equipmentTanks.abstracts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that manage the log
 */
public abstract class GlassaitLogger {
    /**
     * Instance of the logger
     */
    private final Logger logger = LoggerFactory.getLogger(GlassaitLogger.class);

    /**
     * Log an error
     *
     * @param message The error to log
     */
    protected void logError(String message) {
        this.logger.error("ERROR -> " + message);
    }

    /**
     * Lof a debug
     *
     * @param message The debug to log
     */
    protected void logDebug(String message) {
        this.logger.debug("DEBUG -> " + message);
    }
}

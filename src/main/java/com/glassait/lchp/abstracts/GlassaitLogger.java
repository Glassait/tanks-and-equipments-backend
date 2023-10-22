package com.glassait.lchp.abstracts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GlassaitLogger {
    private final Logger logger = LoggerFactory.getLogger(GlassaitLogger.class);

    protected void logError(String message) {
        this.logger.error("ERROR -> " + message);
    }

    protected void logDebug(String message) {
        this.logger.debug("DEBUG -> " + message);
    }
}

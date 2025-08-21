package org.example.lld.loggingframework;

import org.example.lld.loggingframework.enums.LogLevel;

public class LoggingFrameworkDemo {

    public static void main(String[] args) {
        Logger logger = LogManager.getInstance();

        // Logging with default configuration
        // Should log debug and above log levels
        logger.info("This is an information message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        // Changing log level
        logger.setMinLevel(LogLevel.WARN);

        // Should only log warn and above
        logger.debug("This is a debug message");
        logger.info("This is an information message");
        logger.warn("This is an warn message");

        logger.shutdown();

    }
}

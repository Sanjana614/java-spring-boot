package org.example.lld.loggingframework.entity;

import org.example.lld.loggingframework.enums.LogLevel;

import java.time.LocalDateTime;

public class LogMessage {
    private final LogLevel logLevel;
    private final String message;
    private final LocalDateTime timestamp;
    private final String threadName;

    public LogMessage(LogLevel logLevel, String msg) {
        this.logLevel = logLevel;
        this.message = msg;
        this.timestamp = LocalDateTime.now();
        this.threadName = Thread.currentThread().getName();
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getThreadName() {
        return threadName;
    }
}

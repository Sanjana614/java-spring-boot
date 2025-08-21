package org.example.lld.loggingframework.enums;

public enum LogLevel {

    DEBUG,
    INFO,
    WARN,
    ERROR,
    CRITICAL;

    public boolean asSevereAs(LogLevel minLevel) {
        return this.ordinal() >= minLevel.ordinal();
    }
}

package org.example.lld.loggingframework.strategy.appender;

import org.example.lld.loggingframework.entity.LogMessage;
import org.example.lld.loggingframework.strategy.formatter.MessageFormatter;

public abstract class LogAppender {

    protected MessageFormatter formatter;

    public LogAppender(MessageFormatter formatter) {
        this.formatter = formatter;
    }

    public abstract void append(LogMessage logMessage);
}

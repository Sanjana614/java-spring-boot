package org.example.lld.loggingframework.strategy.formatter;

import org.example.lld.loggingframework.entity.LogMessage;

public class SimpleMessageFormatter implements MessageFormatter {

    @Override
    public String format(LogMessage logMessage) {
        return String.format("[%s] [%s] [%s]: [%s]",
                logMessage.getTimestamp(),
                logMessage.getLogLevel(),
                logMessage.getThreadName(),
                logMessage.getMessage());
    }
}

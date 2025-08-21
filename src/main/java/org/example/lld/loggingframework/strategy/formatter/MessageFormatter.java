package org.example.lld.loggingframework.strategy.formatter;

import org.example.lld.loggingframework.entity.LogMessage;

public interface MessageFormatter {
    String format(LogMessage logMessage);
}

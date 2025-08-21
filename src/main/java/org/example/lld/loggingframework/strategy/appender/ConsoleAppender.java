package org.example.lld.loggingframework.strategy.appender;


import org.example.lld.loggingframework.entity.LogMessage;
import org.example.lld.loggingframework.strategy.formatter.MessageFormatter;

public class ConsoleAppender extends LogAppender {

    public ConsoleAppender(MessageFormatter formatter) {
        super(formatter);
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }
}

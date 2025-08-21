package org.example.lld.loggingframework;


import org.example.lld.loggingframework.enums.LogLevel;
import org.example.lld.loggingframework.strategy.appender.ConsoleAppender;
import org.example.lld.loggingframework.strategy.appender.FileAppender;
import org.example.lld.loggingframework.strategy.appender.LogAppender;
import org.example.lld.loggingframework.strategy.formatter.SimpleMessageFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LogManager {
    private static volatile Logger instance;

    public static Logger getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (LogManager.class) {
                if (Objects.isNull(instance)) {
                    instance = new LoggerBuilder()
                            .setLevel(LogLevel.DEBUG)
                            .addAppender(new ConsoleAppender(new SimpleMessageFormatter()))
                            .addAppender(new FileAppender("./log.txt", new SimpleMessageFormatter()))
                            .build();
                }
            }
        }
        return instance;
    }

    public static class LoggerBuilder {
        private LogLevel minLevel = LogLevel.INFO;
        private final List<LogAppender> appenders = new ArrayList<>();

        public LoggerBuilder setLevel(LogLevel level) {
            this.minLevel = level;
            return this;
        }

        public LoggerBuilder addAppender(LogAppender appender) {
            this.appenders.add(appender);
            return this;
        }

        public Logger build() {
            return new Logger(minLevel, appenders);
        }
    }
}

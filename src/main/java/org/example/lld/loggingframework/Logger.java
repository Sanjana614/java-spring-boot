package org.example.lld.loggingframework;

import org.example.lld.loggingframework.entity.LogMessage;
import org.example.lld.loggingframework.enums.LogLevel;
import org.example.lld.loggingframework.strategy.appender.LogAppender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Logger {

    private LogLevel minLevel;
    private final List<LogAppender> appenders;
    private ExecutorService executorService;

    public Logger(LogLevel level, List<LogAppender> appenders) {
        this.minLevel = level;
        this.appenders = appenders;
        executorService = Executors.newSingleThreadExecutor();
    }

    public void log(LogLevel logLevel, String msg) {
        if (!logLevel.asSevereAs(minLevel)) {
            return;
        }
        LogMessage logMessage = new LogMessage(logLevel, msg);
        executorService.submit(() -> appenders.forEach(appender -> appender.append(logMessage)));
    }

    public void debug(String msg) {
        log(LogLevel.DEBUG, msg);
    }

    public void info(String msg) {
        log(LogLevel.INFO, msg);
    }

    public void warn(String msg) {
        log(LogLevel.WARN, msg);
    }

    public void error(String msg) {
        log(LogLevel.ERROR, msg);
    }

    public void critical(String msg) {
        log(LogLevel.CRITICAL, msg);
    }

    public void setMinLevel(LogLevel level) {
        this.minLevel = level;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

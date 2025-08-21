package org.example.lld.loggingframework.strategy.appender;

import org.example.lld.loggingframework.entity.LogMessage;
import org.example.lld.loggingframework.strategy.formatter.MessageFormatter;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender extends LogAppender {
    private final String filePath;

    public FileAppender(String filePath, MessageFormatter formatter) {
        super(formatter);
        this.filePath = filePath;
    }

    @Override
    public synchronized void append(LogMessage logMessage) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(formatter.format(logMessage) + "\n");
            writer.flush();
        } catch (IOException ex) {
            throw new RuntimeException("Exception occurred while writing to file.");
        }
    }
}

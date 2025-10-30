package com.demoProblems.logger.logappender;

import com.demoProblems.logger.LogMessage;
import com.demoProblems.logger.messageformatter.IMessageFormatter;
import com.demoProblems.logger.messageformatter.PlainTextMessageFormatter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Appender that writes log messages to a file
 */
public class FileAppender implements ILogAppender {

    private IMessageFormatter formatter;
    private final String filePath;
    private BufferedWriter writer;

    public FileAppender(String filePath) {
        this.filePath = filePath;
        this.formatter = new PlainTextMessageFormatter();

        try {
            // Create parent directories if they don't exist
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Open file in append mode
            this.writer = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create FileAppender: " + e.getMessage(), e);
        }
    }

    @Override
    public void append(LogMessage logMessage) {
        if (logMessage == null) {
            return;
        }

        try {
            String formattedMessage = formatter.format(logMessage);
            writer.write(formattedMessage);
            writer.newLine();
            writer.flush(); // Ensure it's written immediately
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }

    @Override
    public void setFormatter(IMessageFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public IMessageFormatter getFormatter() {
        return formatter;
    }

    @Override
    public void close() {
        if (writer != null) {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.err.println("Error closing FileAppender: " + e.getMessage());
            }
        }
    }
}

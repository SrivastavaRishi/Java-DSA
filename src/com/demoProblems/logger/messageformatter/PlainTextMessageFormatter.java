package com.demoProblems.logger.messageformatter;

import com.demoProblems.logger.LogMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Formats log messages as plain text
 * Format: [TIMESTAMP] [LEVEL] [THREAD] [CLASS.METHOD] - MESSAGE
 */
public class PlainTextMessageFormatter implements IMessageFormatter {

     //   [2024-10-28 14:30:45.123] [INFO ] [main] [com.example.UserService.login] - User logged in {userId=12345, ip=192.168.1.1}

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private final SimpleDateFormat dateFormatter;

    public PlainTextMessageFormatter() {
        this.dateFormatter = new SimpleDateFormat(DATE_FORMAT);
    }

    @Override
    public String format(LogMessage logMessage) {
        StringBuilder sb = new StringBuilder();

        // [TIMESTAMP]
        sb.append("[");
        sb.append(formatTimestamp(logMessage.getTimestamp()));
        sb.append("] ");

        // [LEVEL]
        sb.append("[");
        sb.append(String.format("%-5s", logMessage.getLevel())); // Left-align, 5 chars
        sb.append("] ");

        // [THREAD]
        sb.append("[");
        sb.append(logMessage.getThreadName());
        sb.append("] ");

        // [CLASS.METHOD]
        if (logMessage.getClassName() != null) {
            sb.append("[");
            sb.append(logMessage.getClassName());
            if (logMessage.getMethodName() != null) {
                sb.append(".");
                sb.append(logMessage.getMethodName());
            }
            sb.append("] ");
        }

        // - MESSAGE
        sb.append("- ");
        sb.append(logMessage.getMessage());

        // Context (if present)
        if (logMessage.getContext() != null && !logMessage.getContext().isEmpty()) {
            sb.append(" {");
            boolean first = true;
            for (Map.Entry<String, Object> entry : logMessage.getContext().entrySet()) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                first = false;
            }
            sb.append("}");
        }

        // Exception (if present)
        if (logMessage.getThrowable() != null) {
            sb.append("\n");
            sb.append(formatThrowable(logMessage.getThrowable()));
        }

        return sb.toString();
    }

    private String formatTimestamp(long timestamp) {
        return dateFormatter.format(new Date(timestamp));
    }

    private String formatThrowable(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        sb.append(throwable.getClass().getName());
        sb.append(": ");
        sb.append(throwable.getMessage());
        sb.append("\n");

        for (StackTraceElement element : throwable.getStackTrace()) {
            sb.append("\tat ");
            sb.append(element.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}

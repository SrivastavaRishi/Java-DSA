package com.demoProblems.logger;

import com.demoProblems.logger.logappender.ILogAppender;

import java.util.ArrayList;
import java.util.List;

/**
 * Main logger class that provides logging functionality
 */
public class Logger {

    private final String name;
    private LogLevel threshold;
    private final List<ILogAppender> appenders;
    private boolean enabled;

    public Logger(String name) {
        this.name = name;
        this.threshold = LogLevel.DEBUG;
        this.appenders = new ArrayList<>();
        this.enabled = true;
    }

    // ========== Main Logging Methods ==========

    public void log(LogLevel level, String message) {
        logInternal(level, message, null, null);
    }

    public void log(LogLevel level, String message, Throwable throwable) {
        logInternal(level, message, null, throwable);
    }

    public void log(LogLevel level, String message, Object... args) {
        logInternal(level, formatMessage(message, args), null, null);
    }

    // ========== Core Internal Method ==========

    private void logInternal(LogLevel level, String message, Object[] args, Throwable throwable) {
        // Check if logger is enabled
        if (!enabled) {
            return;
        }

        // Check if level meets threshold
        if (!level.isGreaterOrEqual(threshold)) {
            return;
        }

        // Get caller information
        StackTraceElement caller = getCallerInfo();

        // Build log message
        LogMessage logMessage = new LogMessage.Builder()
                .message(message)
                .level(level)
                .className(caller != null ? caller.getClassName() : "Unknown")
                .methodName(caller != null ? caller.getMethodName() : "Unknown")
                .throwable(throwable)
                .build();

        // Send to all appenders
        for (ILogAppender appender : appenders) {
            try {
                appender.append(logMessage);
            } catch (Exception e) {
                System.err.println("Error in appender: " + e.getMessage());
            }
        }
    }

    // ========== Configuration Methods ==========

    public void addAppender(ILogAppender appender) {
        if (appender != null && !appenders.contains(appender)) {
            appenders.add(appender);
        }
    }

    public void removeAppender(ILogAppender appender) {
        appenders.remove(appender);
    }

    public void setLogLevel(LogLevel level) {
        this.threshold = level;
    }

    public LogLevel getLogLevel() {
        return threshold;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public boolean isLevelEnabled(LogLevel level) {
        return enabled && level.isGreaterOrEqual(threshold);
    }

    // ========== Helper Methods ==========

    private StackTraceElement getCallerInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > 5) {
            return stackTrace[5];
        }
        return null;
    }

    private String formatMessage(String message, Object... args) {
        if (args == null || args.length == 0) {
            return message;
        }

        String result = message;
        for (Object arg : args) {
            result = result.replaceFirst("\\{\\}", String.valueOf(arg));
        }
        return result;
    }

    public void close() {
        for (ILogAppender appender : appenders) {
            try {
                appender.close();
            } catch (Exception e) {
                System.err.println("Error closing appender: " + e.getMessage());
            }
        }
    }
}
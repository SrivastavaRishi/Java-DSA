package com.demoProblems.logger;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a log message with all its metadata
 */
public class LogMessage {
    private final String message;
    private final LogLevel level;
    private final long timestamp;
    private final String threadName;
    private final String className;
    private final String methodName;
    private final Map<String, Object> context;
    private final Throwable throwable;

    private LogMessage(Builder builder) {
        this.message = builder.message;
        this.level = builder.level;
        this.timestamp = builder.timestamp;
        this.threadName = builder.threadName;
        this.className = builder.className;
        this.methodName = builder.methodName;
        this.context = builder.context;
        this.throwable = builder.throwable;
    }

    // Simple getters
    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * Builder for creating LogMessage
     */
    public static class Builder {
        private String message;
        private LogLevel level;
        private long timestamp;
        private String threadName;
        private String className;
        private String methodName;
        private Map<String, Object> context;
        private Throwable throwable;

        public Builder() {
            // Set default values
            this.timestamp = Instant.now().toEpochMilli();
            this.threadName = Thread.currentThread().getName();
            this.context = new HashMap<>();
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder level(LogLevel level) {
            this.level = level;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder threadName(String threadName) {
            this.threadName = threadName;
            return this;
        }

        public Builder className(String className) {
            this.className = className;
            return this;
        }

        public Builder methodName(String methodName) {
            this.methodName = methodName;
            return this;
        }

        public Builder context(Map<String, Object> context) {
            this.context = context;
            return this;
        }

        public Builder addContext(String key, Object value) {
            this.context.put(key, value);
            return this;
        }

        public Builder throwable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        public LogMessage build() {
            return new LogMessage(this);
        }
    }
}

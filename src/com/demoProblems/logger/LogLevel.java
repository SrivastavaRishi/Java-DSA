package com.demoProblems.logger;

public enum LogLevel {
    DEBUG(100),
    INFO(200),
    WARN(300),
    ERROR(400),
    FATAL(500);

    private final int priority;

    LogLevel(int priority){
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }

    /**
     * Check if this level is greater than or equal to the given level
     */
    public boolean isGreaterOrEqual(LogLevel other) {
        return this.priority >= other.priority;
    }

    @Override
    public String toString() {
        return this.name();
    }

}

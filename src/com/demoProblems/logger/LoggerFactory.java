package com.demoProblems.logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * Factory class for creating and managing Logger instances
 * Implements Singleton pattern with thread-safe logger caching
 */
public class LoggerFactory {

    // Singleton instance
    private static LoggerFactory instance;

    // Cache of loggers by name (thread-safe)
    private final Map<String, Logger> loggerCache;

    // Private constructor (Singleton pattern)
    private LoggerFactory() {
        this.loggerCache = new ConcurrentHashMap<>();
    }

    /**
     * Get singleton instance of LoggerFactory
     * Uses double-checked locking for thread safety
     */
    public static LoggerFactory getInstance() {
        if (instance == null) {
            synchronized (LoggerFactory.class) {
                if (instance == null) {
                    instance = new LoggerFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Get logger by class name
     * Returns existing logger if already created, otherwise creates new one
     *
     * @param clazz The class for which to get the logger
     * @return Logger instance
     */
    public static Logger getLogger(Class<?> clazz) {
        return getInstance().getLoggerByName(clazz.getName());
    }

    /**
     * Get logger by name
     * Returns existing logger if already created, otherwise creates new one
     *
     * @param name The name of the logger
     * @return Logger instance
     */
    public static Logger getLogger(String name) {
        return getInstance().getLoggerByName(name);
    }

    /**
     * Internal method to get or create logger
     * Thread-safe due to ConcurrentHashMap.computeIfAbsent
     */
    private Logger getLoggerByName(String name) {
        return loggerCache.computeIfAbsent(name, Logger::new);
    }

    /**
     * Get all logger names currently in cache
     *
     * @return Array of logger names
     */
    public String[] getLoggerNames() {
        return loggerCache.keySet().toArray(new String[0]);
    }

    /**
     * Get total number of loggers in cache
     *
     * @return Number of cached loggers
     */
    public int getLoggerCount() {
        return loggerCache.size();
    }

    /**
     * Check if a logger with given name exists in cache
     *
     * @param name Logger name to check
     * @return true if logger exists, false otherwise
     */
    public boolean hasLogger(String name) {
        return loggerCache.containsKey(name);
    }

    /**
     * Clear all cached loggers
     * Use with caution - should only be used for testing or shutdown
     */
    public void clearCache() {
        loggerCache.clear();
    }

    /**
     * Remove a specific logger from cache
     *
     * @param name Logger name to remove
     * @return The removed logger, or null if not found
     */
    public Logger removeLogger(String name) {
        return loggerCache.remove(name);
    }
}

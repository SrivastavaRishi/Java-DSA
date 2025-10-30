package com.demoProblems.logger.messageformatter;

import com.demoProblems.logger.LogMessage;

/**
 * Interface for formatting log messages into different output formats
 */
public interface IMessageFormatter {
    /**
     * Format a log message into a string representation
     *
     * @param logMessage the log message to format
     * @return formatted string representation of the log message
     */
    String format(LogMessage logMessage);
}

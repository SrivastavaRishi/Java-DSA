package com.demoProblems.logger.logappender;

import com.demoProblems.logger.LogMessage;
import com.demoProblems.logger.messageformatter.IMessageFormatter;

/**
 * Interface for log appenders that write log messages to different destinations
 */
public interface ILogAppender {
    /**
     * Append a log message to the destination
     *
     * @param logMessage the log message to append
     */
    void append(LogMessage logMessage);

    /**
     * Set the message formatter for this appender
     *
     * @param formatter the message formatter to use
     */
    void setFormatter(IMessageFormatter formatter);

    /**
     * Get the current message formatter
     *
     * @return the current formatter
     */
    IMessageFormatter getFormatter();

    /**
     * Close the appender and release any resources
     */
    void close();
}

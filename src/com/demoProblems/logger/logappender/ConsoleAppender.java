package com.demoProblems.logger.logappender;


import com.demoProblems.logger.LogLevel;
import com.demoProblems.logger.LogMessage;
import com.demoProblems.logger.messageformatter.IMessageFormatter;
import com.demoProblems.logger.messageformatter.PlainTextMessageFormatter;

/**
 * Appender that writes log messages to console (System.out/System.err)
 */
public class ConsoleAppender implements ILogAppender {

    private IMessageFormatter formatter;

    public ConsoleAppender(IMessageFormatter messageFormatter) {
        this.formatter = messageFormatter; // Default formatter
    }

    @Override
    public void append(LogMessage logMessage) {
        if (logMessage == null) {
            return;
        }

        // Format the message
        String formattedMessage = formatter.format(logMessage);
        System.out.println(formattedMessage);

        // ERROR and FATAL go to stderr, others to stdout
//        if (logMessage.getLevel() == LogLevel.ERROR || logMessage.getLevel() == LogLevel.FATAL) {
//            System.err.println(formattedMessage);
//        } else {
//            System.out.println(formattedMessage);
//        }
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
        // Nothing to close for console
    }
}

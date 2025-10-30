package com.demoProblems.logger;

import com.demoProblems.logger.logappender.ConsoleAppender;
import com.demoProblems.logger.logappender.FileAppender;
import com.demoProblems.logger.messageformatter.JsonMessageFormatter;
import com.demoProblems.logger.messageformatter.PlainTextMessageFormatter;

/**
 * Demo application showing logger usage
 */
public class LoggerDemo {

    private static final Logger logger = LoggerFactory.getLogger(LoggerDemo.class);

    public static void main(String[] args) {
        System.out.println("========== Logger System Demo ==========\n");

        // Demo 1: Basic logging
//        demo1_BasicLogging();

//         Demo 2: Multiple appenders
        demo2_MultipleAppenders();

        // Demo 3: Log level filtering
//        demo3_LogLevelFiltering();

        // Demo 4: Exception logging
//        demo4_ExceptionLogging();

        // Demo 5: Message formatting
//        demo5_MessageFormatting();

        // Demo 6: Conditional logging
//        demo6_ConditionalLogging();

        System.out.println("\n========== Demo Complete ==========");
    }

    private static void demo1_BasicLogging() {
        System.out.println("--- Demo 1: Basic Logging ---");

        Logger logger = LoggerFactory.getLogger("Demo1");
        logger.addAppender(new ConsoleAppender(new PlainTextMessageFormatter()));

        logger.log(LogLevel.DEBUG, "This is a debug message");
        logger.log(LogLevel.INFO, "This is an info message");
        logger.log(LogLevel.WARN, "This is a warning message");
        logger.log(LogLevel.ERROR, "This is an error message");
        logger.log(LogLevel.FATAL, "This is a fatal message");

        System.out.println();
    }

    private static void demo2_MultipleAppenders() {
        System.out.println("--- Demo 2: Multiple Appenders (Console + File) ---");

        Logger logger = LoggerFactory.getLogger("Demo2");

        // Console with PlainText
        logger.addAppender(new ConsoleAppender(new PlainTextMessageFormatter()));

        // File with JSON
        logger.addAppender(new FileAppender("./src/com/demoProblems/logger/demo.log", new JsonMessageFormatter()));

        logger.log(LogLevel.INFO, "This message goes to both console and file !!");
        logger.log(LogLevel.WARN, "Another message to multiple destinations");

        System.out.println("Check logs/demo.log for JSON formatted logs\n");
    }
//
//    private static void demo3_LogLevelFiltering() {
//        System.out.println("--- Demo 3: Log Level Filtering ---");
//
//        Logger logger = LoggerFactory.getLogger("Demo3");
//        logger.addAppender(new ConsoleAppender(new PlainTextMessageFormatter()));
//
//        // Set threshold to WARN - only WARN, ERROR, FATAL will be logged
//        logger.setLogLevel(LogLevel.WARN);
//
//        System.out.println("Log level set to WARN (threshold = 300)");
//        logger.log(LogLevel.DEBUG, "Debug - won't be logged (100 < 300)");
//        logger.log(LogLevel.INFO, "Info - won't be logged (200 < 300)");
//        logger.log(LogLevel.WARN, "Warn - WILL be logged (300 >= 300)");
//        logger.log(LogLevel.ERROR, "Error - WILL be logged (400 >= 300)");
//        logger.log(LogLevel.FATAL, "Fatal - WILL be logged (500 >= 300)");
//
//        System.out.println();
//    }
//
//    private static void demo4_ExceptionLogging() {
//        System.out.println("--- Demo 4: Exception Logging ---");
//
//        Logger logger = LoggerFactory.getLogger("Demo4");
//        logger.addAppender(new ConsoleAppender(new PlainTextMessageFormatter()));
//
//        try {
//            int result = 10 / 0;
//        } catch (ArithmeticException e) {
//            logger.log(LogLevel.ERROR, "Division by zero error occurred", e);
//        }
//
//        try {
//            String str = null;
//            str.length();
//        } catch (NullPointerException e) {
//            logger.log(LogLevel.ERROR, "Null pointer exception", e);
//        }
//
//        System.out.println();
//    }
//
//    private static void demo5_MessageFormatting() {
//        System.out.println("--- Demo 5: Message Formatting with Placeholders ---");
//
//        Logger logger = LoggerFactory.getLogger("Demo5");
//        logger.addAppender(new ConsoleAppender(new PlainTextMessageFormatter()));
//
//        String username = "John";
//        String ipAddress = "192.168.1.1";
//        int loginAttempts = 3;
//
//        logger.log(LogLevel.INFO, "User {} logged in from {}", username, ipAddress);
//        logger.log(LogLevel.WARN, "Failed login attempts: {} for user {}", loginAttempts, username);
//        logger.log(LogLevel.INFO, "Processing payment of {} {} for user {}", 100.50, "USD", username);
//
//        System.out.println();
//    }
//
//    private static void demo6_ConditionalLogging() {
//        System.out.println("--- Demo 6: Conditional Logging (Performance Optimization) ---");
//
//        Logger logger = LoggerFactory.getLogger("Demo6");
//        logger.addAppender(new ConsoleAppender(new PlainTextMessageFormatter()));
//        logger.setLogLevel(LogLevel.INFO);  // DEBUG disabled
//
//        // Bad approach - expensive operation runs even if debug is disabled
//        logger.log(LogLevel.DEBUG, "Debug info: {}", expensiveOperation());
//        System.out.println("Expensive operation was called unnecessarily!");
//
//        // Good approach - check before expensive operation
//        if (logger.isLevelEnabled(LogLevel.DEBUG)) {
//            logger.log(LogLevel.DEBUG, "Debug info: {}", expensiveOperation());
//        } else {
//            System.out.println("Debug disabled - expensive operation skipped!");
//        }
//
//        System.out.println();
//    }
//
//    private static String expensiveOperation() {
//        System.out.println("  [Running expensive operation...]");
//        // Simulate expensive computation
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//        return "Expensive data";
//    }
}
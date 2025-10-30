package com.demoProblems.logger.messageformatter;

import com.demoProblems.logger.LogMessage;

import java.util.Map;

/**
 * Formats log messages as JSON
 */
public class JsonMessageFormatter implements IMessageFormatter {

    /*{
            "timestamp": 1730123445123,
            "level": "INFO",
            "thread": "main",
            "class": "com.example.UserService",
            "method": "login",
            "message": "User logged in",
            "context": {
                "userId": "12345",
                "ip": "192.168.1.1"
            }
    }*/

    @Override
    public String format(LogMessage logMessage) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // timestamp
        json.append("\"timestamp\":");
        json.append(logMessage.getTimestamp());
        json.append(",");

        // level
        json.append("\"level\":\"");
        json.append(logMessage.getLevel());
        json.append("\",");

        // thread
        json.append("\"thread\":\"");
        json.append(escapeJson(logMessage.getThreadName()));
        json.append("\",");

        // class
        if (logMessage.getClassName() != null) {
            json.append("\"class\":\"");
            json.append(escapeJson(logMessage.getClassName()));
            json.append("\",");
        }

        // method
        if (logMessage.getMethodName() != null) {
            json.append("\"method\":\"");
            json.append(escapeJson(logMessage.getMethodName()));
            json.append("\",");
        }

        // message
        json.append("\"message\":\"");
        json.append(escapeJson(logMessage.getMessage()));
        json.append("\"");

        // context
        if (logMessage.getContext() != null && !logMessage.getContext().isEmpty()) {
            json.append(",\"context\":{");
            boolean first = true;
            for (Map.Entry<String, Object> entry : logMessage.getContext().entrySet()) {
                if (!first) {
                    json.append(",");
                }
                json.append("\"");
                json.append(escapeJson(entry.getKey()));
                json.append("\":\"");
                json.append(escapeJson(String.valueOf(entry.getValue())));
                json.append("\"");
                first = false;
            }
            json.append("}");
        }

        // exception
        if (logMessage.getThrowable() != null) {
            json.append(",\"exception\":{");
            json.append("\"type\":\"");
            json.append(logMessage.getThrowable().getClass().getName());
            json.append("\",");
            json.append("\"message\":\"");
            json.append(escapeJson(logMessage.getThrowable().getMessage()));
            json.append("\"");
            json.append("}");
        }

        json.append("}");
        return json.toString();
    }

    private String escapeJson(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}

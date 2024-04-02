package com.example.utils;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    private static final Logger logger = LogManager.getLogger(LoggerUtils.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static void logResponseDetails(Response response) {
        if (response != null) {
            logger.info("Response Body: " + response.getBody().asString());
            logger.info("Status Code: " + response.getStatusCode());
        } else {
            logger.warn("Response object is null");
        }
    }
}
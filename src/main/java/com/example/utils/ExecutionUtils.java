package com.example.utils;

import com.example.utils.LoggerUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import io.restassured.response.Response;

public class ExecutionUtils {
    @Step("{description}")
    @Description("{description}")
    public static Response executeWithHandling(ExecutableCode<Response> code, String description) {
        try {
            Response response = code.execute();
            logs(response, description);
            return response;
        } catch (Exception e) {
            logs(e); // Log with exception
            return null;
        }
    }

    private static void logs(Response response, String description) {
        if (response != null) {
            LoggerUtils.logResponseDetails(response);
            Status status = mapStatusCodeToStatus(response.getStatusCode());
            Allure.step(description, status);
        } else {
            LoggerUtils.logError("An error occurred: Response object is null");
        }
    }

    private static Status mapStatusCodeToStatus(int statusCode) {
        return switch (statusCode / 100) {
            case 2 -> Status.PASSED;
            case 4 -> Status.FAILED;
            case 5 -> Status.BROKEN;
            default -> null;
        };
    }
    private static void logs(Exception e) {
        Allure.addAttachment("Error", "text/plain", e.getMessage());
        LoggerUtils.logError("An error occurred: " + e.getMessage());
    }

    @FunctionalInterface
    public interface ExecutableCode<Response> {
        Response execute() throws Exception;
    }
}
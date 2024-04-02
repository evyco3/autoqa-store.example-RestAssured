package com.example.client;

import com.example.models.Payment;
import com.example.utils.ExecutionUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PaymentApiClient implements ApiClient {

    @Step("Create a new payment")
    public Response createPayment(Payment payment){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(payment)
                    .post("/payments");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Creating a new payment");
    }

    @Step("Update an existing payment")
    public Response updatePayment(long id, Payment payment){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(payment)
                    .put("/payments/{id}", id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Updating an existing payment with ID: " + id);
    }

    @Step("Delete a payment")
    public Response deletePayment(long id){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .delete("/payments/{id}", id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Deleting payment with ID: " + id);
    }

    @Step("Get a payment")
    public Response getPayment(long id){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/payments/{id}", id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Getting payment with ID: " + id);
    }

    @Step("Get all payments")
    public Response getAllPayments(){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/payments");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Getting all payments");
    }

    @Step("Get payment details as object")
    public Payment getPaymentAsObject(long id) {
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/payments/{id}", id);
        };
        Response response = ExecutionUtils.executeWithHandling(executableCode,"");

        return response != null && response.getStatusCode() == 200 ? response.as(Payment.class) : null;
    }
}

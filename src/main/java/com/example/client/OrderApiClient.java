package com.example.client;

import com.example.models.Order;
import com.example.utils.ExecutionUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderApiClient implements ApiClient {

    @Step("Create a new order")
    public Response createOrder(Order order) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(order)
                    .post("/orders");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Creating a new order");
    }

    @Step("Update an existing order")
    public Response updateOrder(Order order, long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(order)
                    .put("/orders/{id}", id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Updating an existing order with ID: " + id);
    }

    @Step("Delete an order")
    public Response deleteOrder(long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .delete("/orders/{id}", id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Deleting order with ID: " + id);
    }

    @Step("Get all orders")
    public Response getAllOrders() {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/orders");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Getting all orders");
    }

    @Step("Get order details as object")
    public Order getOrderAsObject(long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/orders/{id}", id);
        };
        Response response = ExecutionUtils.executeWithHandling(executableCode,"Return Order as Object");

        if (response.getStatusCode() == 200) {
            return response.as(Order.class); // Deserialize response body into an Order object
        } else {
            return null; // Or handle error accordingly
        }
    }
}

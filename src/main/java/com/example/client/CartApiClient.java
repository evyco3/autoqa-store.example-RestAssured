package com.example.client;

import com.example.models.Cart;
import com.example.utils.ExecutionUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CartApiClient implements ApiClient {

    @Step("Create a new cart")
    public Response createCart(Cart cart) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(cart)
                    .post("/carts");
        };
        String description = "Creating a new cart with ID: " + cart.getId();
        return ExecutionUtils.executeWithHandling(executableCode, description);
    }

    @Step("Update an existing cart")
    public Response updateCart(Cart cart, long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(cart)
                    .put("/carts/{id}", id);
        };
        String description = "Updating cart with ID: " + id;
        return ExecutionUtils.executeWithHandling(executableCode, description);
    }

    @Step("Delete a cart")
    public Response deleteCart(long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .delete("/carts/{id}", id);
        };
        String description = "Deleting cart with ID: " + id;
        return ExecutionUtils.executeWithHandling(executableCode, description);
    }

    @Step("Get details of a cart")
    public Response getCart(long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/carts/{id}", id);
        };
        String description = "Retrieving details of cart with ID: " + id;
        return ExecutionUtils.executeWithHandling(executableCode, description);
    }

    @Step("Get all carts")
    public Response getAllCarts() {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/carts");
        };
        String description = "Retrieving all carts";
        return ExecutionUtils.executeWithHandling(executableCode, description);
    }

    @Step("Get cart details as object")
    public Cart getCartAsObject(long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/carts/{id}", id);
        };
        Response response = ExecutionUtils.executeWithHandling(executableCode,"Return Cart as Object");

        assert response != null;
        if (response.getStatusCode() == 200) {
            return response.as(Cart.class);
        } else {
            return null;
        }
    }
}

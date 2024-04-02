package com.example.client;

import com.example.models.Product;
import com.example.utils.ExecutionUtils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProductApiClient implements ApiClient{

    @Step("Create a new product")
    public Response createProduct(Product product){
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(product)
                    .post("/products");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Creating a new product");
    }

    @Step("Update an existing product")
    public Response updateProduct(long id,Product product){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(product)
                    .put("/products/{id}",id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Updating an existing product with ID: " + id);
    }

    @Step("Delete a product")
    public Response deleteProduct(long id){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .delete("/products/{id}",id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Deleting product with ID: " + id);
    }

    @Step("Get a product")
    public Response getProduct(long id){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/products/{id}",id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Getting product with ID: " + id);
    }

    @Step("Get all products")
    public Response getAllProducts(){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/products");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Getting all products");
    }

    @Step("Get product details as object")
    public Product getProductAsObject(long id) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/products/{id}", id);
        };
        Response response = ExecutionUtils.executeWithHandling(executableCode,"");

        return response != null && response.getStatusCode() == 200 ? response.as(Product.class) : null;
    }

}

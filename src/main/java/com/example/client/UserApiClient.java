package com.example.client;

import com.example.models.User;
import com.example.utils.ExecutionUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserApiClient implements ApiClient{

    // Create a new user
    public Response createUser(User user){
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(user)
                    .post("/users");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Creating a new user");
    }

    // Delete a user by ID
    public Response deleteUser(long id){
        ExecutionUtils.ExecutableCode<Response>executableCode=()->{
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .delete("/users/{id}", id);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Deleting user with ID: " + id);
    }

    // Update a user by ID
    public Response updateUser(int userId, User updatedUser) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .body(updatedUser)
                    .put("/users/{userid}", userId);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Updating user with ID: " + userId);
    }

    // Get all users
    public Response getUsers() {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/users");
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Getting all users");
    }

    // Get a user by ID
    public Response getUserById(long userId) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/users/{userid}", userId);
        };
        return ExecutionUtils.executeWithHandling(executableCode, "Getting user with ID: " + userId);
    }

    // Get user details as object by ID
    public User getUserAsObject(long userId) {
        ExecutionUtils.ExecutableCode<Response> executableCode = () -> {
            return RestAssured
                    .given()
                    .baseUri(BASE_URI)
                    .contentType(ContentType.JSON)
                    .get("/users/{userid}", userId);
        };
        Response response = ExecutionUtils.executeWithHandling(executableCode,"");

        assert response != null;
        if (response.getStatusCode() == 200) {
            return response.as(User.class);
        } else {
            return null;
        }
    }
}

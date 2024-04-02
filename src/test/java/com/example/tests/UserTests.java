package com.example.tests;

import com.example.client.UserApiClient;
import com.example.models.User;
import io.restassured.response.Response;

import org.testng.annotations.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTests {
    @Test
    public void createUserTest(){
        User user=new User(6L,"gad","gad@example.com");
        Response response=getUserApiClient().createUser(user);
        assertThat(response.getStatusCode()).isEqualTo(201);
    }
    @Test
    public void deleteUserTest(){
        Response response= getUserApiClient().deleteUser(4);
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    public void updateUserTest(){
        User user=new User(1L,"evy","evy@example.co.il");
        Response response= getUserApiClient().updateUser(1,user);
        assertThat(response.getStatusCode()).isEqualTo(200);
    }
    @Test
    public void getUser(){
        Response response= getUserApiClient().getUserById(1);
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    private UserApiClient getUserApiClient(){
        return new UserApiClient();
    }

}

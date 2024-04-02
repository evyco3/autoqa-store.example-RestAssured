package com.example.tests;

import com.example.client.CartApiClient;
import com.example.client.OrderApiClient;
import com.example.client.UserApiClient;
import com.example.models.Cart;
import com.example.models.Order;
import com.example.models.User;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class OrderTests {
    @Test
    public void createOrderTest(){
        User user=new UserApiClient().getUserAsObject(1L);
        Cart cart=new CartApiClient().getCartAsObject(1L);
        Order order=new Order(1L,user,cart);
        Response response= getOrderApiClient().createOrder(order);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }
    private OrderApiClient getOrderApiClient(){
        return new OrderApiClient();
    }
}

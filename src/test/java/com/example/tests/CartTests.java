package com.example.tests;

import com.example.client.CartApiClient;

import com.example.client.ProductApiClient;
import com.example.models.Cart;
import com.example.models.Product;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CartTests {

    @Test()
    public void createCartTest() {
        Product tablet = getProductApiClient().getProductAsObject(3L);
        Product desktop=getProductApiClient().getProductAsObject(1L);
        Cart cart=new Cart();
        cart.addProduct(tablet);
        cart.addProduct(desktop);
        cart.setId(3L);
        Response response=getCartApiClient().createCart(cart);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Test
    public void deleteCartTest(){
        Response response= getCartApiClient().deleteCart(2L);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
    @Test
    public void getCartTest(){
        Response response= getCartApiClient().getCart(1L);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    public void getAllCarts(){
        Response response= getCartApiClient().getAllCarts();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

    private CartApiClient getCartApiClient() {
        return new CartApiClient();
    }

    private ProductApiClient getProductApiClient() {
        return new ProductApiClient();
    }


}

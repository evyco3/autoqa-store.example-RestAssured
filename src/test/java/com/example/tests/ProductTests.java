package com.example.tests;

import com.example.client.ProductApiClient;
import com.example.models.Product;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests {

    @Test
    public void createProductTest(){
        Product product=new Product();
        product.setId(3L);
        product.setName("Tablet");
        product.setPrice(1100);
        Response response= getProductApiClient().createProduct(product);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }

    @Test
    public void updateProductTest(){
        Product product=new Product(2L,"Laptop",1770);
        Response response= getProductApiClient().updateProduct(1L,product);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    public void deleteProductTest(){
        Response response= getProductApiClient().deleteProduct(2L);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
    @Test
    public void getProductTest(){
        Response response= getProductApiClient().getProduct(1L);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
    @Test
    public void getAllProductsTest(){
        Response response= getProductApiClient().getAllProducts();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
    private ProductApiClient getProductApiClient(){
        return new ProductApiClient();
    }
}

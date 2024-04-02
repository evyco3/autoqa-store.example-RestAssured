package com.example.tests;

import com.example.client.OrderApiClient;
import com.example.client.PaymentApiClient;
import com.example.models.Order;
import com.example.models.Payment;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PaymentTest {

    @Test
    public void createPaymentTest(){
        Order order=new OrderApiClient().getOrderAsObject(1L);
        System.out.println(order.getCart().getTotalAmount());
        double amount=order.getCart().getTotalAmount();
        Payment payment=new Payment(order,amount);
        Response response= getPaymentApiClient().createPayment(payment);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);

    }

    private PaymentApiClient getPaymentApiClient(){
        return new PaymentApiClient();
    }
}

package com.example.productservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "order-service")
//@Component
public interface OrderServiceClient {
    @GetMapping("/test2")
    public String getOrderTest();
}

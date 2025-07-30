package com.park0587.orderhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrderHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderHandlerApplication.class, args);
    }

}

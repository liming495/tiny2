package com.guppy.d;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class D1ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(D1ServiceApplication.class, args);
    }

}

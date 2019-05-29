package com.guppy.d;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class D2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(D2ServiceApplication.class, args);
    }

}

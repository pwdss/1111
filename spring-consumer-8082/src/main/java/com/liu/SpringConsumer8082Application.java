package com.liu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringConsumer8082Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringConsumer8082Application.class, args);
    }

}

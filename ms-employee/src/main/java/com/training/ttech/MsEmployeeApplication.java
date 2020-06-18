package com.training.ttech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsEmployeeApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsEmployeeApplication.class,
                              args);
    }

}

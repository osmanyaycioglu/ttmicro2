package com.training.ttech;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class MsDepartmentApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsDepartmentApplication.class,
                              args);
    }

}

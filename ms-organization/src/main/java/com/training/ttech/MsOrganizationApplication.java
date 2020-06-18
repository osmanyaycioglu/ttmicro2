package com.training.ttech;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRabbit
@RibbonClient(name = "EMPLOYEE", configuration = RibbonConf.class)
public class MsOrganizationApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsOrganizationApplication.class,
                              args);
    }

}

package com.training.ttech;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_response_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(value = "dep_direct_response_ex",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "dep_response_key"))
    public void listenQueue(final String str) {
        System.out.println("Response : " + str);
    }


}

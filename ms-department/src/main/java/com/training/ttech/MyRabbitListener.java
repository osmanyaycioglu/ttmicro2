package com.training.ttech;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "department_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(value = "dep_direct_ex",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "dep_key"))
    @SendTo("dep_direct_response_ex/dep_response_key")
    public String listenQueue(final Department str) {
        System.out.println("gelen : " + str);
        return "Get : " + str.getName() + ":" + str.getEmployeeCount();
    }


}

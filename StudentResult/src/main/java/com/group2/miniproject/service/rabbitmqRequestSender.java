package com.group2.miniproject.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class rabbitmqRequestSender {


    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public rabbitmqRequestSender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.request.routingkey.name}")
    private String routingkey;

    public void send(String stuname) {
        rabbitTemplate.convertAndSend(exchange, routingkey, stuname);
        System.out.println("Send msg = " + stuname);
    }

}


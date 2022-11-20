package com.group2.miniproject.service;

import com.group2.miniproject.model.ExamResult;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class rabbitmqResponseSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.response.routingkey.name}")
    private String routingkey;

    public void send(String studetails) {
        rabbitTemplate.convertAndSend(exchange, routingkey, studetails);
        System.out.println("Send msg = " + studetails);
    }
}

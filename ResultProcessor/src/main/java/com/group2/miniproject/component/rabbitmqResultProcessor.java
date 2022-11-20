package com.group2.miniproject.component;

import com.group2.miniproject.model.ExamResult;
import com.group2.miniproject.model.ResRepo;
import com.group2.miniproject.service.rabbitmqResponseSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class rabbitmqResultProcessor {

    private final rabbitmqResponseSender rabbitmqSender;
    private final ResRepo repo;

    @Autowired
    public rabbitmqResultProcessor(ResRepo repo, rabbitmqResponseSender rabbitmqSender) {
        this.repo = repo;
        this.rabbitmqSender = rabbitmqSender;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "${rabbitmq.request.queue.name}")
    public void recievedMessage(String stuname) {
        System.out.println("msg " + stuname);
        if (repo.findByName(stuname) == null){
            rabbitmqSender.send("student name not found in database");
        } else {
            ExamResult examResult = repo.findByName(stuname);
            rabbitmqSender.send(examResult.toString());
        }
    }
}

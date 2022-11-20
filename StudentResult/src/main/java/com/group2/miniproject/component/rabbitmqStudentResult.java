package com.group2.miniproject.component;

import com.group2.miniproject.model.ExamResult;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class rabbitmqStudentResult {

    public static String result;

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "${rabbitmq.response.queue.name}")
    public void recievedMessage(String examresult) {
        System.out.println("data received");
        result = examresult;
    }

}

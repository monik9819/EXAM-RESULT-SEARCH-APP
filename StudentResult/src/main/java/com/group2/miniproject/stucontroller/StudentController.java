package com.group2.miniproject.stucontroller;

import com.group2.miniproject.component.rabbitmqStudentResult;
import com.group2.miniproject.model.ExamResult;
import com.group2.miniproject.service.rabbitmqRequestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final rabbitmqRequestSender rabbitSender;

    @Autowired
    public StudentController(rabbitmqRequestSender rabbitSender) {
        this.rabbitSender = rabbitSender;
    }

    @GetMapping("/getresult")
    public String getData(@RequestParam String name) {
        rabbitSender.send(name);
        return rabbitmqStudentResult.result;
    }
}

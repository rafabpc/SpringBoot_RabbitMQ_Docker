package com.application.controller;

import com.application.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @RequestMapping(value = "/rabbitmq_message", method = RequestMethod.GET)
    public @ResponseBody String rabbitMQMessage(@RequestParam("message") String message) throws InterruptedException {
        rabbitMQSender.sendMessage(message);
        return "Message sent to RabbitMQ: " + message;
    }


}

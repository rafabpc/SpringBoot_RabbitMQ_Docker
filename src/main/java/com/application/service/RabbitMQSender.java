package com.application.service;

import com.application.component.RabbitMQReceiver;
import com.application.configuration.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQReceiver rabbitMQReceiver;

    public void sendMessage(String message) throws InterruptedException {
        System.out.println("Sending a message to RabbitMQ = " + message);
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME, RabbitMQConfiguration.ROUTING_KEY, message);
        rabbitMQReceiver.getLatch().await(5000, TimeUnit.MILLISECONDS);
    }

}
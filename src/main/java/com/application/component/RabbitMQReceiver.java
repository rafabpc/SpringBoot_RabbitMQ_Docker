package com.application.component;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class RabbitMQReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Message Received from RabbitMQ =  " + message + "");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}

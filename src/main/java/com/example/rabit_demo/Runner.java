package com.example.rabit_demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        while(true) {
            System.out.println("Sending message...");
            rabbitTemplate.convertAndSend(RabitDemoApplication.exchangeName, "", "Hello from RabbitMQ!");
            Thread.sleep(2000);
        }
    }

}


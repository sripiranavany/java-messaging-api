package com.sripiranavan.spring.rabbitmq.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageProducerApp {
    final static String QUEUE_NAME = "spring-boot-queue";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);

        rabbitTemplate.convertAndSend(QUEUE_NAME, "Hello World!");
        System.out.println("Message sent");
        context.close();
    }
}

package com.sripiranavan.spring.rabbitmq.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class MessageConsumerApp {

    final static String QUEUE_NAME = "spring-boot-queue";

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
        MessageReceiver receiver = context.getBean(MessageReceiver.class);

        receiver.getCountDownLatch().await(2000, TimeUnit.SECONDS);
    }
}

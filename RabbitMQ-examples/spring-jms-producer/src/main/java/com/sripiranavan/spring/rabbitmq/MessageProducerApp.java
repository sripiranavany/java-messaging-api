package com.sripiranavan.spring.rabbitmq;


import com.sripiranavan.spring.rabbitmq.config.RabbitMQConfig;
import com.sripiranavan.spring.rabbitmq.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageProducerApp {
    private static final String QUEUE_NAME = "spring-boot-queue";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);

        Product product = new Product(1, "Product 1", 10);

        rabbitTemplate.convertAndSend(QUEUE_NAME, product);
        System.out.println("Message sent to queue: " + QUEUE_NAME);

        context.close();
    }
}

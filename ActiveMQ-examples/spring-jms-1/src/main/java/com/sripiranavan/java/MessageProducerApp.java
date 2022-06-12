package com.sripiranavan.java;

import com.sripiranavan.java.config.AppConfig;
import com.sripiranavan.java.producer.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = context.getBean(MessageSender.class);

        messageSender.sendMessage("Hello Sripiranavan!");
        System.out.println("Message sent!");
        ((AbstractApplicationContext) context).close();
    }
}

package com.sripiranavan.java;

import com.sripiranavan.java.config.AppConfig;
import com.sripiranavan.java.receiver.MessageReceiver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageConsumerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageReceiver messageReceiver = context.getBean(MessageReceiver.class);
        String response = messageReceiver.receiveMessage();
        System.out.println("Message received: " + response);
        ((AbstractApplicationContext) context).close();
    }
}

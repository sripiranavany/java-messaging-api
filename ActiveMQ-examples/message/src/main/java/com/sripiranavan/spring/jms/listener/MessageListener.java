package com.sripiranavan.spring.jms.listener;

import com.sripiranavan.spring.jms.config.JmsConfig;
import com.sripiranavan.spring.jms.model.GreetingMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MessageListener {
    @JmsListener(destination = JmsConfig.QUEUE_NAME)
    public void listen(@Payload GreetingMessage greetingMessage, @Headers MessageHeaders messageHeaders, Message message){
        System.out.println("Greeting received");
        System.out.println(greetingMessage);
    }
}

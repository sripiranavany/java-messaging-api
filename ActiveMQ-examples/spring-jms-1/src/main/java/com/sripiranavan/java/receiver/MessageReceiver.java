package com.sripiranavan.java.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MessageReceiver {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    MessageConverter messageConverter;

    public String receiveMessage() {
        try{
            Message message = jmsTemplate.receive();
            String response = messageConverter.fromMessage(message).toString();
            return response;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

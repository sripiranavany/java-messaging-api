package com.sripiranavan.java.receiver;

import com.sripiranavan.java.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class ProductMessageReceiver {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    MessageConverter messageConverter;

    public Product receiveMessage() {
        try{
            Message message = jmsTemplate.receive();
            Product response = (Product) messageConverter.fromMessage(message);
            return response;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

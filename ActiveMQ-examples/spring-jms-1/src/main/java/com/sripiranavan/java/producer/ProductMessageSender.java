package com.sripiranavan.java.producer;

import com.sripiranavan.java.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class ProductMessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendProduct(final Product product) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(product);
                return objectMessage;
            }
        });
    }
}

package com.sripiranavan.spring.jms.consumer;

import com.sripiranavan.spring.jms.model.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "boot-queue")
    public void messageListener(SystemMessage systemMessage){
        LOGGER.info("Message received: {}", systemMessage);
    }
}

package com.sripiranavan.spring.jms.sender;

import com.sripiranavan.spring.jms.config.JmsConfig;
import com.sripiranavan.spring.jms.model.GreetingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MessageSender {
    private final JmsTemplate jmsTemplate;
    private static Integer ID = 1;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("Greetings user");
        GreetingMessage message = GreetingMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello user " + ID++)
                .build();
        jmsTemplate.convertAndSend(JmsConfig.QUEUE_NAME, message);

        System.out.println("Message sent");
    }
}

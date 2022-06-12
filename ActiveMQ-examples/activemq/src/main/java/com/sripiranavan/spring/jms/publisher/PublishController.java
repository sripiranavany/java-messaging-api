package com.sripiranavan.spring.jms.publisher;

import com.sripiranavan.spring.jms.model.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody SystemMessage systemMessage){
        try{
            jmsTemplate.convertAndSend("boot-queue", systemMessage);
            return ResponseEntity.ok("Message sent");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

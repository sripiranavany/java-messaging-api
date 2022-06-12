package com.sripiranavan.java.jms.receiver;

import com.sripiranavan.java.jms.model.Product;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;


//@Component
//public class ProductReceiver implements MessageListener {
//    @Autowired
//    JmsTemplate jmsTemplate;
//    @Autowired
//    MessageConverter messageConverter;
//    @Override
//    public void onMessage(Message message) {
//        try{
//            Product product = (Product) messageConverter.fromMessage(message);
//            System.out.println("Received product: " + product);
//        }catch (JMSException e){
//            e.printStackTrace();
//        }
//    }
//}
@Component
public class ProductReceiver{
    private static final String QUEUE_NAME = "messageQueue";
    @JmsListener(destination = QUEUE_NAME)
    public void receiveMessage(final Message<Product> message){
        MessageHeaders headers = message.getHeaders();
        System.out.println("headers: " + headers);

        Product product = message.getPayload();
        System.out.println("Received product: " + product);
    }
}
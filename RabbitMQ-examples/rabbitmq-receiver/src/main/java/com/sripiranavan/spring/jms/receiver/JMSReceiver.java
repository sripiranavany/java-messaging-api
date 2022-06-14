package com.sripiranavan.spring.jms.receiver;

import com.rabbitmq.client.Channel;
import com.sripiranavan.spring.jms.model.Product;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

@Component
public class JMSReceiver implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println("Received message: " + message.toString());
        byte[] body = message.getBody();
        Product product = (Product) getObject(body);
        System.out.println("Received product: " + product);
//        Positively acknowledge the message
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

    private Object getObject(byte[] body) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(body);
        ObjectInput in = new ObjectInputStream(bis);
        return in.readObject();
    }
}

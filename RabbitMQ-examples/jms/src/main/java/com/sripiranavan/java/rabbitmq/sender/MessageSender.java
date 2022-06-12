package com.sripiranavan.java.rabbitmq.sender;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sripiranavan.java.rabbitmq.model.Product;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MessageSender {
    private final static String QUEUE_NAME = "product-queue";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");

        try(
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()
        ){
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            Product product = new Product(1, "Laptop", 10);

            byte[] byteArray = getByteArray(product);

            channel.basicPublish("", QUEUE_NAME, null, byteArray);
            System.out.println(" [x] Sent '" + product + "'");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static byte[] getByteArray(Product product) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(product);
        return outputStream.toByteArray();
    }
}

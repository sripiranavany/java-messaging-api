package com.sripiranavan.java;

import com.sripiranavan.java.config.AppConfig;
import com.sripiranavan.java.model.Product;
import com.sripiranavan.java.receiver.ProductMessageReceiver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ProductConsumerApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductMessageReceiver productMessageReceiver = context.getBean(ProductMessageReceiver.class);
        Product product = productMessageReceiver.receiveMessage();
        System.out.println("Product received: " + product);
        ((AbstractApplicationContext) context).close();
    }
}

package com.sripiranavan.java;

import com.sripiranavan.java.config.AppConfig;
import com.sripiranavan.java.model.Product;
import com.sripiranavan.java.producer.MessageSender;
import com.sripiranavan.java.producer.ProductMessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ProductMessageProducerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductMessageSender productMessageSender = context.getBean(ProductMessageSender.class);

        Product product = new Product();
        product.setProductId(100);
        product.setName("Laptop");
        product.setQuantity(10);

        productMessageSender.sendProduct(product);
        System.out.println("Message sent!");
        ((AbstractApplicationContext) context).close();
    }
}

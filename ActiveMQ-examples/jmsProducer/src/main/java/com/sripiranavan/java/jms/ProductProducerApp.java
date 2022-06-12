package com.sripiranavan.java.jms;

import com.sripiranavan.java.jms.config.AppConfig;
import com.sripiranavan.java.jms.model.Product;
import com.sripiranavan.java.jms.producer.ProductSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ProductProducerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductSender productSender = context.getBean(ProductSender.class);

        Product product = new Product();
        product.setProductId(100);
        product.setName("Laptop");
        product.setQuantity(10);

        productSender.sendProduct(product);
        System.out.println("Message sent!");
        ((AbstractApplicationContext) context).close();

    }
}

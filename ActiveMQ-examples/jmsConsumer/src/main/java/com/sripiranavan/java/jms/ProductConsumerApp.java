package com.sripiranavan.java.jms;

import com.sripiranavan.java.jms.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ProductConsumerApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        try {
            Thread.sleep(50000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((AbstractApplicationContext) context).close();
    }
}

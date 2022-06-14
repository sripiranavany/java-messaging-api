package com.sripiranavan.spring.rabbitmq;

import com.sripiranavan.spring.rabbitmq.model.Product;

import java.util.concurrent.CountDownLatch;

public class MessageReceiver {
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void receiveMsg(Product product){
        System.out.println("Product object is Received: "+product);
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch(){
        return countDownLatch;
    }
}

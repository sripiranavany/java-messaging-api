package com.sripiranavan.spring.rabbitmq.config;

import java.util.concurrent.CountDownLatch;

public class MessageReceiver {
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}

package com.sripiranavan.spring.jms;

import com.sripiranavan.spring.jms.config.RabbitMQConfig;
import com.sripiranavan.spring.jms.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqProducerApplication implements CommandLineRunner {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product(1, "Product 1", 10);

		System.out.println("Sending product: " + product);
		rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_NAME, "spring-message-topic-exchange-routing-key", product);
		System.out.println("Product sent");
	}
}

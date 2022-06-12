package com.sripiranavan.java.jms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.sripiranavan.java.jms")
@Import({MessagingConfig.class})
public class AppConfig {
}

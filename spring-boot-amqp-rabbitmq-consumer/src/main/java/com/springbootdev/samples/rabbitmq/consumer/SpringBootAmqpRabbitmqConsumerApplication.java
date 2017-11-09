package com.springbootdev.samples.rabbitmq.consumer;

import com.springbootdev.samples.rabbitmq.consumer.listener.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootAmqpRabbitmqConsumerApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAmqpRabbitmqConsumerApplication.class);

    @Autowired
    private Consumer consumer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpRabbitmqConsumerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("application is up and running and pulling RabbitMQ messages");
        consumer.pullMessage();
    }
}

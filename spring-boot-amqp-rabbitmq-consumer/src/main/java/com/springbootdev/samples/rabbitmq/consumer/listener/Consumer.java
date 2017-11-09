package com.springbootdev.samples.rabbitmq.consumer.listener;

import com.springbootdev.samples.rabbitmq.consumer.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private static final String QUEUE_NAME = "orders_queue";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void pullMessage()
    {
        LOGGER.info("receiving the message ");
        Object message = rabbitTemplate.receiveAndConvert(QUEUE_NAME);

        if (message != null) {
            Order order = (Order) message;
            LOGGER.info("  received message [" + order.toString() + "] ");
        }
    }
}


package com.net.javaguide.orderservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class emailConsumer {


    private static final Logger logger = LoggerFactory.getLogger(emailConsumer.class);
    @KafkaListener(topics = "emailTopic", groupId = "{$spring.kafka.consumer.group-id}")
    public void consume(String message) {
        logger.info(String.format("Message recieved from emailService -> %s", message));
    }

}

package com.net.javaguide.orderservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class emailConsumer {


    private static final Logger logger = LoggerFactory.getLogger(emailConsumer.class);
    @KafkaListener(topics = "emailTopic", groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("Message recieved from emailService -> %s", message));
    }

}

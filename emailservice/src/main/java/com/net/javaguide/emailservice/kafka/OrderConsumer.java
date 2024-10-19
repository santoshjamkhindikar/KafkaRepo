package com.net.javaguide.emailservice.kafka;

import com.net.javaguide.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    EmailProducer emailProducer;

    @KafkaListener(
            topics = "${spring.kafka.topi.name}"
            , groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent order) {
        logger.info(String.format("#### -> Consumed message -> %s", order.toString()));
        logger.info(String.format("#### -> Consumed message -> %s", order.getOrder().toString()));
        logger.info(String.format("#### -> Consumed message -> %s", order.getStatus()));
        logger.info(String.format("#### -> Consumed message -> %s", order.getMessage()));

        emailProducer.sendMessages("Email sent to user for order id: "+order.getOrder().getOrderId());


    }
}

package com.net.javaguide.emailservice.kafka;

import com.net.javaguide.basedomains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {
    private static final Logger logger = LoggerFactory.getLogger(EmailProducer.class);
    @Autowired
    private NewTopic topic;

    @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessages(String Message) {
        logger.info("EmailProducer: Message sent successfully : "+Message);
        kafkaTemplate.send(topic.name(), Message);
    }
}

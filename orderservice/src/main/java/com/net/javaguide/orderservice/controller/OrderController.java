package com.net.javaguide.orderservice.controller;

import com.net.javaguide.basedomains.dto.Order;
import com.net.javaguide.basedomains.dto.OrderEvent;
import com.net.javaguide.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderProducer orderProducer;


    @PostMapping("/orders")
    public String order(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setStatus("Pending");
        orderEvent.setMessage("Order is in pending state");
        orderProducer.sendMessages(orderEvent);
        return "Order sent to Kafka";
    }
}

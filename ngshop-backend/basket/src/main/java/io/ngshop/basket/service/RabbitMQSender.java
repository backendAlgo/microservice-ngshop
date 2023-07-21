package io.ngshop.basket.service;

import io.ngshop.basket.Request;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.ngshop.basket.config.Config.exchange;
import static io.ngshop.basket.config.Config.routingKey;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(Request request) {
        amqpTemplate.convertAndSend(exchange, routingKey, request);
        System.out.println("Send msg = " + request);

    }
}

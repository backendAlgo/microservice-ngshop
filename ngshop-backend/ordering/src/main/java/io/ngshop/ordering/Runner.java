package io.ngshop.ordering;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        IntStream.range(0, 10)
                .forEach(i -> rabbitTemplate.convertAndSend(Config.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ! " + i));
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}

package com.example.clientservice.messaging.producer;

import com.example.clientservice.constants.RoutingKeys;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagingProducerService {
    private AsyncRabbitTemplate asyncRabbitTemplate;

    @Async
    public void sendMessageToClientQueue(Object message) {
        asyncRabbitTemplate.convertSendAndReceive("amq.direct", RoutingKeys.ACCOUNT_MOVEMENT_QUEUE, message);
    }
}

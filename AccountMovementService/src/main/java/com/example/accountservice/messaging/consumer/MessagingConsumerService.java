package com.example.accountservice.messaging.consumer;

import com.example.accountservice.constants.RoutingKeys;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagingConsumerService {
    @RabbitListener(queues = RoutingKeys.CLIENT_QUEUE)
    public void receiveRequest(Object message) {

    }
}

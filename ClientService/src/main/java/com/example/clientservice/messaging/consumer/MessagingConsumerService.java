package com.example.clientservice.messaging.consumer;

import com.example.clientservice.constants.RoutingKeys;
import com.example.clientservice.messaging.request.ClientQueueRequest;
import com.example.clientservice.messaging.response.ClientQueueResponse;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagingConsumerService {
    @RabbitListener(queues = RoutingKeys.CLIENT_QUEUE)
    public String receiveRequest(String message) {
        ClientQueueResponse clientQueueResponse = new ClientQueueResponse();

        return "RECIBIDO";
    }
}

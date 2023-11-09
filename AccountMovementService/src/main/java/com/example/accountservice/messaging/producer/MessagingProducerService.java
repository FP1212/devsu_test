package com.example.accountservice.messaging.producer;

import com.example.accountservice.constants.RoutingKeys;
import com.example.accountservice.account.dto.ClientRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class MessagingProducerService {
    private AsyncRabbitTemplate asyncRabbitTemplate;

    @Async
    public CompletableFuture<String> sendMessageToClientQueue(ClientRequestDto message) throws ExecutionException, InterruptedException {
//        ClientQueueResponse clientQueueResponse = asyncRabbitTemplate.convertSendAndReceiveAsType("amq.direct", RoutingKeys.CLIENT_QUEUE, message, new ParameterizedTypeReference<ClientQueueResponse>() {}).get();
        return asyncRabbitTemplate.convertSendAndReceiveAsType(RoutingKeys.CLIENT_QUEUE, "HOLA", new ParameterizedTypeReference<String>() {});
    }
}

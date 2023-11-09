package com.example.clientservice.client.service;

import com.example.clientservice.client.model.Client;
import com.example.clientservice.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;

@Service
@AllArgsConstructor
public class ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
    private ClientRepository clientRepository;

    public ResponseEntity<?> post(Client client) {
        try {
            if (clientRepository.existsByName(client.getName())){
                return ResponseEntity.badRequest().body("Client already exists");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(client));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<?> get(Long id) {
        return clientRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> getByName(String name) {
        return clientRepository.findByName(URLDecoder.decode(name)).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> put(Long id, Client newClient) {
        if (clientRepository.existsById(id)) {
            newClient.setId(id);
            return ResponseEntity.ok(clientRepository.save(newClient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> delete(Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

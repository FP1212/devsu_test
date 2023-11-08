package com.example.clientservice.client.controller;

import com.example.clientservice.client.model.Client;
import com.example.clientservice.client.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/clientes")
public class ClientController {

    private ClientService clientService;

    @PostMapping
    public ResponseEntity saveClient(@Valid @RequestBody Client client) {
        return clientService.post(client);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getClient(@PathVariable Long id) {
        return clientService.get(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.put(id, client);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        return clientService.delete(id);
    }
}

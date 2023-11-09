package com.example.clientservice.client.controller;

import com.example.clientservice.client.dto.ClientDto;
import com.example.clientservice.client.model.Client;
import com.example.clientservice.client.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clientes")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return clientService.get(id);
    }

    @GetMapping
    public ResponseEntity getByName(@RequestParam String name) {
        return clientService.getByName(name);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity put(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity patch(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return clientService.patch(id, clientDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return clientService.delete(id);
    }
}

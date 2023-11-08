package com.example.accountservice.movements.controller;

import com.example.accountservice.movements.model.Movement;
import com.example.accountservice.movements.service.MovementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/movimientos")
public class MovementController {

    private MovementService movementService;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Movement movement) {
        return movementService.post(movement);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return movementService.get(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Movement movement) {
        return movementService.put(id, movement);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return movementService.delete(id);
    }
}

package com.example.accountservice.movements.controller;

import com.example.accountservice.movements.dto.MovementDto;
import com.example.accountservice.movements.model.Movement;
import com.example.accountservice.movements.service.MovementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movimientos")
public class MovementController {

    private final MovementService movementService;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Movement movement) {
        return movementService.post(movement);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return movementService.get(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody MovementDto movementDto) {
        return movementService.put(id, movementDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return movementService.delete(id);
    }
}

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
    public ResponseEntity post(@Valid @RequestBody Movement movement) {
        return movementService.save(movement);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return movementService.get(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity put(@PathVariable Long id, @Valid @RequestBody Movement movement) {
        return movementService.update(id, movement);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity patch(@PathVariable Long id, @Valid @RequestBody MovementDto movementDto) {
        return movementService.patch(id, movementDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return movementService.delete(id);
    }
}

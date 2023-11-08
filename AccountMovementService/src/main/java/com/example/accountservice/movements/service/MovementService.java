package com.example.accountservice.movements.service;

import com.example.accountservice.movements.model.Movement;
import com.example.accountservice.movements.repository.MovementRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovementService {
    private static final Logger logger = LoggerFactory.getLogger(MovementService.class);
    private MovementRepository movementRepository;

    public ResponseEntity<?> post(Movement account) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(movementRepository.save(account));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<?> get(Long id) {
        return movementRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> put(Long id, Movement newMovement) {
        if (movementRepository.existsById(id)) {
            newMovement.setId(id);
            return ResponseEntity.ok(movementRepository.save(newMovement));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> delete(Long id) {
        movementRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

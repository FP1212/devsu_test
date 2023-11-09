package com.example.accountservice.movements.service;

import com.example.accountservice.account.model.Account;
import com.example.accountservice.account.repository.AccountRepository;
import com.example.accountservice.movements.dto.MovementDto;
import com.example.accountservice.movements.model.Movement;
import com.example.accountservice.movements.repository.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovementService {
    private static final Logger logger = LoggerFactory.getLogger(MovementService.class);
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> post(Movement movement) {
        try {
            Optional<Account> optionalAccount = accountRepository.findByNumber(movement.getNumber());

            if (optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                movement.setBalance(account.getBalance() + movement.getValue());

                if (movement.getBalance() >= 0) {
                    account.setBalance(movement.getBalance());
                    accountRepository.save(account);
                    movement.setStatus(Boolean.TRUE);
                    return ResponseEntity.status(HttpStatus.CREATED).body(movementRepository.save(movement));
                } else {
                    movement.setStatus(Boolean.FALSE);
                    movementRepository.save(movement);
                    return ResponseEntity.badRequest().body("Saldo no disponible");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Not Found");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    public ResponseEntity<?> get(Long id) {
        return movementRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> put(Long id, MovementDto movementDto) {
        return movementRepository.findById(id).map(movement -> {
            if (StringUtils.isNotBlank(movementDto.getNumber())) {
                movement.setNumber(movementDto.getNumber());
            }

            if (Objects.nonNull(movementDto.getType())) {
                movement.setType(movementDto.getType());
            }

            if (Objects.nonNull(movementDto.getBalance())) {
                movement.setBalance(movementDto.getBalance());
            }

            if (Objects.nonNull(movementDto.getStatus())) {
                movement.setStatus(movementDto.getStatus());
            }

            if (Objects.nonNull(movementDto.getValue())) {
                movement.setValue(movementDto.getValue());
            }

            return ResponseEntity.ok(movementRepository.save(movement));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(Long id) {
        movementRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

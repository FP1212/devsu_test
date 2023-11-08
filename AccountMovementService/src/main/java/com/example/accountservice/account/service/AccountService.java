package com.example.accountservice.account.service;

import com.example.accountservice.account.model.Account;
import com.example.accountservice.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    private AccountRepository accountRepository;

    public ResponseEntity<?> post(Account account) {
        try {
            if (accountRepository.existsByNumber(account.getNumber())){
                return ResponseEntity.badRequest().body("Account already exists");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(accountRepository.save(account));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<?> get(Long id) {
        return accountRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> put(Long id, Account newAccount) {
        if (accountRepository.existsById(id)) {
            newAccount.setId(id);
            return ResponseEntity.ok(accountRepository.save(newAccount));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> delete(Long id) {
        accountRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

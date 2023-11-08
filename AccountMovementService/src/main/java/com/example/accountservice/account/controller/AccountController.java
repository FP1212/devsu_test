package com.example.accountservice.account.controller;

import com.example.accountservice.account.model.Account;
import com.example.accountservice.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cuentas")
public class AccountController {

    private AccountService accountService;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Account account) {
        return accountService.post(account);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return accountService.get(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Account account) {
        return accountService.put(id, account);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return accountService.delete(id);
    }
}

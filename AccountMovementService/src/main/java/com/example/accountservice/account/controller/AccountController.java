package com.example.accountservice.account.controller;

import com.example.accountservice.account.dto.AccountDto;
import com.example.accountservice.account.model.Account;
import com.example.accountservice.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cuentas")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody AccountDto accountDto) {
        return accountService.save(accountDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return accountService.get(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity put(@PathVariable Long id, @Valid @RequestBody Account account) {
        return accountService.update(id, account);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity patch(@PathVariable Long id, @Valid @RequestBody AccountDto accountDto) {
        return accountService.patch(id, accountDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return accountService.delete(id);
    }
}

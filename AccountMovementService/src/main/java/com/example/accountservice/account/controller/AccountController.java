package com.example.accountservice.account.controller;

import com.example.accountservice.account.dto.AccountDto;
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
    public ResponseEntity save(@Valid @RequestBody AccountDto accountDto) {
        return accountService.post(accountDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable Long id) {
        return accountService.get(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody AccountDto accountDto) {
        return accountService.put(id, accountDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return accountService.delete(id);
    }
}

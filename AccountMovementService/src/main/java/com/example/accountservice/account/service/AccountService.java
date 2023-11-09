package com.example.accountservice.account.service;

import com.example.accountservice.account.dto.AccountDto;
import com.example.accountservice.account.dto.ClientResponseDto;
import com.example.accountservice.account.model.Account;
import com.example.accountservice.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;

    @Value("${app.client.api.url}")
    private String clientServiceApiUrl;

    public ResponseEntity<?> post(AccountDto accountDto) {
        try {
            if (accountRepository.existsByNumber(accountDto.getNumber())){
                return ResponseEntity.badRequest().body("Account already exists");
            }

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(clientServiceApiUrl + "clientes")
                    .queryParam("name", accountDto.getClientName());

            ResponseEntity<ClientResponseDto> response = restTemplate.exchange(builder.toUriString(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ClientResponseDto>() {
            });

            ClientResponseDto clientResponseDto = response.getBody();

            if (Objects.nonNull(clientResponseDto) && clientResponseDto.isStatus()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(accountRepository.save(
                        Account.builder()
                                .clientId(clientResponseDto.getId())
                                .balance(accountDto.getBalance())
                                .type(accountDto.getType())
                                .number(accountDto.getNumber())
                                .status(accountDto.getStatus())
                                .build())
                );
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<?> get(Long id) {
        return accountRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> put(Long id, AccountDto accountDto) {
        return accountRepository.findById(id).map(account -> {
            if (StringUtils.isNotBlank(accountDto.getNumber())) {
                account.setNumber(accountDto.getNumber());
            }

            if (Objects.nonNull(accountDto.getType())) {
                account.setType(accountDto.getType());
            }

            if (Objects.nonNull(accountDto.getBalance())) {
                account.setBalance(accountDto.getBalance());
            }

            if (Objects.nonNull(accountDto.getStatus())) {
                account.setStatus(accountDto.getStatus());
            }

            return ResponseEntity.ok(accountRepository.save(account));
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(Long id) {
        accountRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.accountservice.account.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class AccountDto {
    @Size(max = 20)
    private String number;
    private Integer type;
    private Double balance = 0d;
    private Boolean status;
    private String clientName;
}

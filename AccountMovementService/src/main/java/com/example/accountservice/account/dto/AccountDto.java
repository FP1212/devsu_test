package com.example.accountservice.account.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountDto {
    @Size(max = 20)
    private String number;
    private Integer type;
    private Double balance = 0d;
    private Boolean status;
    private String clientName;
}

package com.example.accountservice.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String password;
    private boolean status;
    private Date auditCreationDate;
}

package com.example.accountservice.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AccountTypeEnum {
    AHORROS(0),CORRIENTE(1);

    private final int accountType;
}

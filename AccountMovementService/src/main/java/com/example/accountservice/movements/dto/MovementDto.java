package com.example.accountservice.movements.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MovementDto {
    private Integer type;
    private Double value;
    private Double balance;
    private Boolean status;

    @Size(max = 20)
    private String number;
}

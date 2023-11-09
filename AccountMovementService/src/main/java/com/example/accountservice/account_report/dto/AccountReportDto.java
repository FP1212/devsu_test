package com.example.accountservice.account_report.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AccountReportDto {
    private Date date;
    private String clientName;
}

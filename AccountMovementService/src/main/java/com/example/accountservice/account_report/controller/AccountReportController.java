package com.example.accountservice.account_report.controller;

import com.example.accountservice.account_report.dto.AccountReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reportes")
public class AccountReportController {

    @GetMapping
    public ResponseEntity getReport(@ModelAttribute AccountReportDto accountReportDto) {
        return null;
    }
}

package com.example.clientservice.client.report;

import com.example.clientservice.user.report.UserReport;
import lombok.Data;

@Data
public class ClientReport extends UserReport {
    private String name;
    private Integer genre;
    private Integer age;
    private String address;
    private boolean status;
}

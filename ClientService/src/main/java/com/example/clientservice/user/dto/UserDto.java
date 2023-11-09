package com.example.clientservice.user.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @Size(max = 50)
    private String name;
    private Integer genre;
    private Integer age;
    @Size(max = 100)
    private String address;
    @Size(max = 20)
    private String phone;
}

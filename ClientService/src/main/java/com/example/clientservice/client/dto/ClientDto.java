package com.example.clientservice.client.dto;

import com.example.clientservice.user.dto.UserDto;
import lombok.Data;

@Data
public class ClientDto extends UserDto {
    private String name;
    private String password;
    private Boolean status;
}

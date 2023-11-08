package com.example.clientservice.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(max = 50)
    private String name;
    private Integer genre;
    private Integer age;

    @NonNull
    @Size(max = 1090)
    private String address;

    @Size(max = 20)
    private String phone;

    @CreatedDate
    private Date auditCreationDate;
}

package com.example.clientservice.user.model;

import com.example.clientservice.audit.model.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@MappedSuperclass
@NoArgsConstructor
@Data
public class User extends Auditable<String> {
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
}

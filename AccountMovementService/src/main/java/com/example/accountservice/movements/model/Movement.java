package com.example.accountservice.movements.model;

import com.example.accountservice.account.model.Account;
import com.example.accountservice.audit.model.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@Data
public class Movement extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Integer type;

    @NonNull
    private Double value;

    private Double balance;

    private Boolean status;

    @NonNull
    @Size(max = 20)
    private String number;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
}

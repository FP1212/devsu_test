package com.example.accountservice.account.repository;

import com.example.accountservice.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT case when count (account) > 0 " +
            "then true" +
            " else false" +
            " end" +
            " from Movement account where account.number = :number")
    boolean existsByNumber(@Param("number") Long number);
}

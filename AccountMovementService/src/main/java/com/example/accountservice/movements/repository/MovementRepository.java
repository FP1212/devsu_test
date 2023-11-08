package com.example.accountservice.movements.repository;

import com.example.accountservice.movements.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}

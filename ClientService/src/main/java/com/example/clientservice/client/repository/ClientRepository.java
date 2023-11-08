package com.example.clientservice.client.repository;

import com.example.clientservice.client.model.Client;
import com.example.clientservice.client.report.ClientReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT name," +
            "genre," +
            "age," +
            "address," +
            "status" +
            " FROM Client  WHERE id = :id")
    Optional<ClientReport> findClientReportById(@Param("id") Long id);

    @Query("SELECT case when count (client) > 0 " +
            "then true" +
            " else false" +
            " end" +
            " from Client client where client.name = :name")
    boolean existsByName(@Param("name") String name);
}

package com.devsu.hackerearth.backend.client.adapter.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsu.hackerearth.backend.client.domain.model.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByPerson_Dni(String dni);
}

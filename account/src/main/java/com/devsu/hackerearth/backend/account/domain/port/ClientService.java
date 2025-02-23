package com.devsu.hackerearth.backend.account.domain.port;

import java.util.Optional;

import com.devsu.hackerearth.backend.account.domain.model.entity.Client;

public interface ClientService {
    public Optional<Client> getById(Long id);
}

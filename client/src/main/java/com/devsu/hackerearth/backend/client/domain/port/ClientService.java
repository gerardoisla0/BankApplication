package com.devsu.hackerearth.backend.client.domain.port;

import java.util.List;
import java.util.Optional;

import com.devsu.hackerearth.backend.client.domain.model.entity.Client;

public interface ClientService {
    List<Client> findAllClients();
    Client createClient(Client client);
    Optional<Client> getClient(Long id);
    Optional<Client> getClientByPersonDni(String id);
    void deleteClient(Client client);
    void updateClient(Client client);
}
package com.devsu.hackerearth.backend.client.adapter.database.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.devsu.hackerearth.backend.client.adapter.database.repository.ClientRepository;
import com.devsu.hackerearth.backend.client.domain.model.entity.Client;
import com.devsu.hackerearth.backend.client.domain.port.ClientService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
       return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> getClientByPersonDni(String id) {
        return clientRepository.findByPerson_Dni(id);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }
    
}

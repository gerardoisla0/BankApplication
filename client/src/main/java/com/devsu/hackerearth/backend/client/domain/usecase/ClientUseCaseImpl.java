package com.devsu.hackerearth.backend.client.domain.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.ClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.PartialClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.outbound.ClientResponseDto;
import com.devsu.hackerearth.backend.client.adapter.mapper.ClientMapper;
import com.devsu.hackerearth.backend.client.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.client.config.response.exception.BusinessException;
import com.devsu.hackerearth.backend.client.domain.model.entity.Client;
import com.devsu.hackerearth.backend.client.domain.port.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientUseCaseImpl implements ClientUseCase {

    private final ClientService clientService;

    @Override
    public List<ClientResponseDto> getAll() {
        List<Client> listClient = clientService.findAllClients();
        return ClientMapper.MAPPER.listDomainToData(listClient);
    }

    @Override
    public ClientResponseDto getById(Long id) {
        Client client = getClientById(id);
        return ClientMapper.MAPPER.domainToData(client);
    }

    @Override
    public ClientResponseDto create(ClientRequestDto clientDto) {
        Client client = ClientMapper.MAPPER.dataToDomain(clientDto);
        CheckIfClientExistByDni(client.getPerson().getDni());
        return ClientMapper.MAPPER.domainToData(clientService.createClient(client));
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto clientDto) {
        Client existingClient = getClientById(id);
        existingClient.getPerson().setDni(clientDto.getDni());
        existingClient.getPerson().setName(clientDto.getName());
        existingClient.getPerson().setGender(clientDto.getGender());
        existingClient.getPerson().setAge(clientDto.getAge());
        existingClient.getPerson().setAddress(clientDto.getAddress());
        existingClient.getPerson().setPhone(clientDto.getPhone());
        clientService.updateClient(existingClient);
        return ClientMapper.MAPPER.domainToData(existingClient);
    }

    @Override
    public ClientResponseDto partialUpdate(Long id, PartialClientRequestDto clientDto) {
        Client existingClient = getClientById(id);
        if (clientDto.getDni() != null)
            existingClient.getPerson().setDni(clientDto.getDni());
        if (clientDto.getName() != null)
            existingClient.getPerson().setName(clientDto.getName());
        if (clientDto.getGender() != null)
            existingClient.getPerson().setGender(clientDto.getGender());
        if (clientDto.getAge() != null)
            existingClient.getPerson().setAge(clientDto.getAge());
        if (clientDto.getAddress() != null)
            existingClient.getPerson().setAddress(clientDto.getAddress());
        if (clientDto.getPhone() != null)
            existingClient.getPerson().setPhone(clientDto.getPhone());
        clientService.updateClient(existingClient);
        return ClientMapper.MAPPER.domainToData(existingClient);
    }

    @Override
    public void deleteById(Long id) {
        Client client = getClientById(id);
        clientService.deleteClient(client);
    }

    private Client getClientById(Long id) {
        return clientService.getClient(id)
                .orElseThrow(() -> new BusinessException(MessageResponse.CLIENT_NOT_EXIST));
    }

    private void CheckIfClientExistByDni(String dni) {
        Optional<Client> clientOptional = clientService.getClientByPersonDni(dni);
        if (clientOptional.isPresent()) {
            throw new BusinessException(MessageResponse.CLIENT_EXIST);
        }
    }
}

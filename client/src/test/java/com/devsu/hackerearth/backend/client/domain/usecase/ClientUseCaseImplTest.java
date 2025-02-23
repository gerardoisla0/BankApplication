package com.devsu.hackerearth.backend.client.domain.usecase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.ClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.outbound.ClientResponseDto;
import com.devsu.hackerearth.backend.client.config.response.exception.BusinessException;
import com.devsu.hackerearth.backend.client.domain.model.entity.Client;
import com.devsu.hackerearth.backend.client.domain.model.entity.Person;
import com.devsu.hackerearth.backend.client.domain.port.ClientService;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Uses case client user")
class ClientUseCaseImplTest {

    private ClientUseCaseImpl clientUseCaseImpl;
    @Mock
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        clientUseCaseImpl = new ClientUseCaseImpl(clientService);
    }

    @Test
    @DisplayName("When Get all Clients, then return Data")
    void whenGetAllClients() {
        List<Client> clientMock = buildClients();
        when(clientService.findAllClients()).thenReturn(clientMock);
        List<ClientResponseDto> response = clientUseCaseImpl.getAll();
        Assertions.assertEquals(clientMock.get(0).getPerson().getName(), response.get(0).getName());
    }

    @Test
    @DisplayName("When Get Client by Id, then return Data")
    void whenGetClientById() {
        Optional<Client> clientMock = buildClientOptional();
        when(clientService.getClient(any())).thenReturn(clientMock);
        ClientResponseDto response = clientUseCaseImpl.getById(1L);
        Assertions.assertEquals(clientMock.get().getPerson().getName(), response.getName());
    }

    @Test
    @DisplayName("When Register Client, then return Bussiness Error")
    void whenGetErrorOnSaveClient() {
        Optional<Client> clientMock = buildClientOptional();
        Client clientRegister = buildClient();
        when(clientService.getClientByPersonDni(any())).thenReturn(clientMock);
        when(clientService.createClient(any())).thenReturn(clientRegister);
        Assertions.assertThrows(BusinessException.class, () -> {
            clientUseCaseImpl.create(buildRequest());
        }, "El usuario que intenta realizar la petición no es válido");
    }

    private ClientRequestDto buildRequest() {
        return new ClientRequestDto("47154490", "Julio", "1234", "M", 33, "siemrvpva", "9839493");
    }

    private List<Client> buildClients() {
        return List.of(
                buildClient());
    }

    private Client buildClient() {
        return Client.builder().isActive(false).password("1234").person(buildPerson()).build();
    }

    private Optional<Client> buildClientOptional() {
        return Optional.of(Client.builder().isActive(false).password("1234").person(buildPerson()).build());
    }

    private Person buildPerson() {
        return Person.builder().name("Julio Isla").dni("47154490").age(33).address("siemre").gender("M").phone("939393")
                .build();
    }
}

package com.devsu.hackerearth.backend.client.adapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.ClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.outbound.ClientResponseDto;
import com.devsu.hackerearth.backend.client.domain.model.entity.Client;

@Mapper
public interface ClientMapper {
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "password", source = "clientDto.password")
    @Mapping(target = "person.name", source = "clientDto.name")
    @Mapping(target = "person.dni", source = "clientDto.dni")
    @Mapping(target = "person.gender", source = "clientDto.gender")
    @Mapping(target = "person.age", source = "clientDto.age")
    @Mapping(target = "person.address", source = "clientDto.address")
    @Mapping(target = "person.phone", source = "clientDto.phone")
    Client dataToDomain(ClientRequestDto clientDto);

    @Mapping(target = "name", source = "client.person.name")
    @Mapping(target = "dni", source = "client.person.dni")
    @Mapping(target = "gender", source = "client.person.gender")
    @Mapping(target = "age", source = "client.person.age")
    @Mapping(target = "address", source = "client.person.address")
    @Mapping(target = "phone", source = "client.person.phone")
    @Mapping(target = "id", source = "client.id")
    ClientResponseDto domainToData(Client client);

    List<Client> listDataToDomain(List<ClientRequestDto> client);

    List<ClientResponseDto> listDomainToData(List<Client> client);

}
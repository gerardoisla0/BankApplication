package com.devsu.hackerearth.backend.account.adapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.AccountRequestDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.AccountResponseDto;
import com.devsu.hackerearth.backend.account.domain.model.entity.Account;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    
    @Mapping(target = "number", source = "accountDto.number")
    @Mapping(target = "type", source = "accountDto.type")
    @Mapping(target = "initialAmount", source = "accountDto.initialAmount")
    @Mapping(target = "active", source = "accountDto.active")
    @Mapping(target = "clientId", source = "accountDto.clientId")
    Account dataToDomain(AccountRequestDto accountDto);

    @Mapping(target = "id", source = "account.id")
    @Mapping(target = "number", source = "account.number")
    @Mapping(target = "type", source = "account.type")
    @Mapping(target = "initialAmount", source = "account.initialAmount")
    @Mapping(target = "active", source = "account.active")
    @Mapping(target = "clientId", source = "account.clientId")
    AccountResponseDto domainToData(Account account);

    List<Account> listDataToDomain(List<AccountRequestDto> account);

    List<AccountResponseDto> listDomainToData(List<Account> account);
}

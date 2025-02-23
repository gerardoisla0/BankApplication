package com.devsu.hackerearth.backend.account.adapter.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.TransactionRequestDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.TransactionResponseDto;
import com.devsu.hackerearth.backend.account.domain.model.entity.Transaction;

@Mapper
public interface TransactionMapper {

    TransactionMapper MAPPER = Mappers.getMapper(TransactionMapper.class);

    @Mapping(target = "date", source = "transactionDto.date", qualifiedByName = "stringToLocalDateTime")
    @Mapping(target = "type", source = "transactionDto.type")
    @Mapping(target = "amount", source = "transactionDto.amount")
    @Mapping(target = "accountId", source = "transactionDto.accountId")
    Transaction dataToDomain(TransactionRequestDto transactionDto);

    @Mapping(target = "date", source = "transaction.date", qualifiedByName = "localDateTimeToString")
    @Mapping(target = "id", source = "transaction.id")
    @Mapping(target = "type", source = "transaction.type")
    @Mapping(target = "amount", source = "transaction.amount")
    @Mapping(target = "balance", source = "transaction.balance")    
    @Mapping(target = "accountId", source = "transaction.accountId")
    TransactionResponseDto domainToData(Transaction transaction);

    List<Transaction> listDataToDomain(List<TransactionRequestDto> transactionDto);

    List<TransactionResponseDto> listDomainToData(List<Transaction> transaction);

    @Named("stringToLocalDateTime")
    static LocalDateTime stringToLocalDateTime(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);
    }

    @Named("localDateTimeToString")
    static String localDateTimeToString(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }
}

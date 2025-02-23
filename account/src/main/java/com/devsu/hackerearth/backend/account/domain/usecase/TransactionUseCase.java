package com.devsu.hackerearth.backend.account.domain.usecase;

import java.util.List;

import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.TransactionResponseDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.TransactionRequestDto;

public interface TransactionUseCase {
    public List<TransactionResponseDto> getAll();

    public TransactionResponseDto getById(Long id);

    public TransactionResponseDto create(TransactionRequestDto transactionDto);
}

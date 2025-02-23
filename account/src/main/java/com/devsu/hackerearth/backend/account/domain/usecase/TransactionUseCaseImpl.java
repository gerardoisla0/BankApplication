package com.devsu.hackerearth.backend.account.domain.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.TransactionRequestDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.TransactionResponseDto;
import com.devsu.hackerearth.backend.account.adapter.mapper.TransactionMapper;
import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.account.config.response.exception.BusinessException;
import com.devsu.hackerearth.backend.account.domain.model.entity.Account;
import com.devsu.hackerearth.backend.account.domain.model.entity.Transaction;
import com.devsu.hackerearth.backend.account.domain.port.TransactionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionUseCaseImpl implements TransactionUseCase {

    private final TransactionService transactionService;

    @Override
    public List<TransactionResponseDto> getAll() {
        List<Transaction> listTransaction = transactionService.getAll();
        return TransactionMapper.MAPPER.listDomainToData(listTransaction);
    }

    @Override
    public TransactionResponseDto getById(Long id) {
        Transaction transaction = getTransactionById(id);
        return TransactionMapper.MAPPER.domainToData(transaction);
    }

    @Override
    public TransactionResponseDto create(TransactionRequestDto transactionDto) {
        Account account = CheckIfAccountExistById(transactionDto.getAccountId());
        Transaction transaction = TransactionMapper.MAPPER.dataToDomain(transactionDto);
        return TransactionMapper.MAPPER.domainToData(transactionService.create(transaction, account));
    }

    private Transaction getTransactionById(Long id) {
        return transactionService.getById(id)
                .orElseThrow(() -> new BusinessException(MessageResponse.TRANSACTION_NOT_EXIST));
    }

    private Account CheckIfAccountExistById(Long id) {
        return transactionService.getAccountById(id)
                .orElseThrow(() -> new BusinessException(MessageResponse.ACCOUNT_NOT_EXIST));
    }

}

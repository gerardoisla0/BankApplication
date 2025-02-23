package com.devsu.hackerearth.backend.account.domain.usecase;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.AccountDetailDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.BankStatementResponseDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.TransactionDetailDto;
import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.account.config.response.exception.BusinessException;
import com.devsu.hackerearth.backend.account.domain.model.entity.Account;
import com.devsu.hackerearth.backend.account.domain.model.entity.Client;
import com.devsu.hackerearth.backend.account.domain.model.entity.Person;
import com.devsu.hackerearth.backend.account.domain.model.entity.Transaction;
import com.devsu.hackerearth.backend.account.domain.port.AccountService;
import com.devsu.hackerearth.backend.account.domain.port.TransactionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportUseCaseImpl implements ReportUseCase {

    private final AccountService accountService;
    private final TransactionService transactionService;

    @Override
    public BankStatementResponseDto getAllByAccountClientIdAndDateBetween(Long clientId, Date dateTransactionStart,
            Date dateTransactionEnd) {

        Client client = CheckIfClientExistById(clientId);
        Person person = CheckIfPersonExistById(client.getPerson_id());
        List<Account> accounts = accountService.findByClientId(clientId);
        List<AccountDetailDto> accountDetails = accounts.stream().map(account -> {
            List<Transaction> transactions = transactionService.findByAccountIdAndDateBetween(account.getId(),
                    dateTransactionStart, dateTransactionEnd);
            List<TransactionDetailDto> transactionDetails = transactions.stream().map(transaction -> 
                new TransactionDetailDto(
                    transaction.getDate().toString(),
                    transaction.getType(),
                    transaction.getAmount(),
                    transaction.getBalance()
                )).collect(Collectors.toList());

                return new AccountDetailDto(
                    account.getNumber(),
                    account.getType(),
                    account.getInitialAmount(),
                    account.isActive(),
                    transactionDetails
                );
        }).collect(Collectors.toList());
        
        return new BankStatementResponseDto(clientId, new Date(), person.getName(), person.getDni(), accountDetails);
    }

    private Client CheckIfClientExistById(Long id) {
        return accountService.getClientById(id)
                .orElseThrow(() -> new BusinessException(MessageResponse.CLIENT_NOT_EXIST));
    }

    private Person CheckIfPersonExistById(Long id) {
        return accountService.getPersonById(id)
                .orElseThrow(() -> new BusinessException(MessageResponse.PERSON_NOT_EXIST));
    }
}

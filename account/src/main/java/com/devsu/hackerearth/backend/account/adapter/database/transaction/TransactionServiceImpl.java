package com.devsu.hackerearth.backend.account.adapter.database.transaction;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.devsu.hackerearth.backend.account.adapter.database.repository.AccountRepository;
import com.devsu.hackerearth.backend.account.adapter.database.repository.TransactionRepository;
import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.account.config.response.exception.BusinessException;
import com.devsu.hackerearth.backend.account.domain.model.entity.Account;
import com.devsu.hackerearth.backend.account.domain.model.entity.Transaction;
import com.devsu.hackerearth.backend.account.domain.port.TransactionService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction create(Transaction transaction, Account account) {
        if(transaction.getType().equals("WITHDRAWAL") && account.getInitialAmount() < Math.abs(transaction.getAmount())){
            throw new BusinessException(MessageResponse.INSUFFICIENT_BALANCE);
         }
         double newBalance = account.getInitialAmount() + transaction.getAmount();
         transaction.setBalance(newBalance);
         account.setInitialAmount(newBalance);
         accountRepository.save(account);
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Transaction> findByAccountIdAndDateBetween(Long clientId, Date dateTransactionStart, Date dateTransactionEnd){
        LocalDateTime startDate = convertToLocalDateTime(dateTransactionStart);
        LocalDateTime endDate = convertToLocalDateTime(dateTransactionEnd);
        return transactionRepository.findByAccountIdAndDateBetween(clientId, startDate, endDate);
    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
}

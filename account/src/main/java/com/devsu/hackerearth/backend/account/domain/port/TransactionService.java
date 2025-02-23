package com.devsu.hackerearth.backend.account.domain.port;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.devsu.hackerearth.backend.account.domain.model.entity.Account;
import com.devsu.hackerearth.backend.account.domain.model.entity.Transaction;

public interface TransactionService {
    public List<Transaction> getAll();
	public Optional<Transaction> getById(Long id);
	public Transaction create(Transaction transaction, Account account);
    public List<Transaction> findByAccountIdAndDateBetween(Long clientId, Date dateTransactionStart, Date dateTransactionEnd);
    public Optional<Account> getAccountById(Long id);
}

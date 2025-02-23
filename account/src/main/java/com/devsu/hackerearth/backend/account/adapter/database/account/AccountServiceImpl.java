package com.devsu.hackerearth.backend.account.adapter.database.account;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.devsu.hackerearth.backend.account.adapter.database.repository.AccountRepository;
import com.devsu.hackerearth.backend.account.adapter.database.repository.ClientRepository;
import com.devsu.hackerearth.backend.account.adapter.database.repository.PersonRepository;
import com.devsu.hackerearth.backend.account.domain.model.entity.Account;
import com.devsu.hackerearth.backend.account.domain.model.entity.Client;
import com.devsu.hackerearth.backend.account.domain.model.entity.Person;
import com.devsu.hackerearth.backend.account.domain.port.AccountService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final PersonRepository personRepository;

    @Override
    public List<Account> getAll() {
       return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getById(Long id) {
         return accountRepository.findById(id);
    }

    @Override
    public Account create(Account account) {
          return accountRepository.save(account);
    }

    @Override
    public void update(Account account) {
          accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Optional<Account> getAccountByNumber(String number) {
        return accountRepository.findByNumber(number);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Account> findByClientId(Long clientId) {
        return accountRepository.findByClientId(clientId);
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }
    
}

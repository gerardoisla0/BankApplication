package com.devsu.hackerearth.backend.account.domain.port;

import java.util.List;
import java.util.Optional;

import com.devsu.hackerearth.backend.account.domain.model.entity.Account;
import com.devsu.hackerearth.backend.account.domain.model.entity.Client;
import com.devsu.hackerearth.backend.account.domain.model.entity.Person;

public interface AccountService {

    public List<Account> getAll();
	public List<Account> findByClientId(Long clientId);
	public Optional<Account> getById(Long id);
	public Optional<Client> getClientById(Long id);
	public Optional<Account> getAccountByNumber(String number);
	public Account create(Account account);
	public void update(Account account);
	public void delete(Account account);
	public Optional<Person> getPersonById(Long id);

}

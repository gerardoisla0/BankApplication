package com.devsu.hackerearth.backend.account.domain.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.AccountRequestDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.PartialAccountRequestDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.AccountResponseDto;
import com.devsu.hackerearth.backend.account.adapter.mapper.AccountMapper;
import com.devsu.hackerearth.backend.account.domain.model.entity.Account;
import com.devsu.hackerearth.backend.account.domain.model.entity.Client;
import com.devsu.hackerearth.backend.account.domain.port.AccountService;
import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.account.config.response.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountUseCaseImpl implements AccountUseCase {

   private final AccountService accountService;

    @Override
    public List<AccountResponseDto> getAll() {
        List<Account> listAccount = accountService.getAll();
        return AccountMapper.MAPPER.listDomainToData(listAccount);
    }

    @Override
    public AccountResponseDto getById(Long id) {
      Account account = getAccountById(id);
      return AccountMapper.MAPPER.domainToData(account);
    }

    @Override
    public AccountResponseDto create(AccountRequestDto accountRequestDto) {
       CheckIfClientExistById(accountRequestDto.getClientId());
       Account account = AccountMapper.MAPPER.dataToDomain(accountRequestDto);
       CheckIfAccountExistByNumber(account.getNumber());
       return AccountMapper.MAPPER.domainToData(accountService.create(account));
    }

    @Override
    public AccountResponseDto update(Long id, AccountRequestDto accountRequestDto) {
      CheckIfClientExistById(accountRequestDto.getClientId());
      Account existingAccount = getAccountById(id);
      existingAccount.setNumber(accountRequestDto.getNumber());
      existingAccount.setType(accountRequestDto.getType().name());
      existingAccount.setInitialAmount(accountRequestDto.getInitialAmount());
      existingAccount.setActive(accountRequestDto.isActive());
      existingAccount.setClientId(accountRequestDto.getClientId());
      accountService.update(existingAccount);
      return AccountMapper.MAPPER.domainToData(existingAccount);
    }

    @Override
    public AccountResponseDto partialUpdate(Long id, PartialAccountRequestDto accountRequestDto) {
    Account existingAccount = getAccountById(id);
    CheckIfClientExistById(accountRequestDto.getClientId());

    if (accountRequestDto.getNumber() != null)
        existingAccount.setNumber(accountRequestDto.getNumber());
    if (accountRequestDto.getType() != null)
        existingAccount.setType(accountRequestDto.getType());
    if (accountRequestDto.getInitialAmount() != null)
        existingAccount.setInitialAmount(accountRequestDto.getInitialAmount());
      if (accountRequestDto.getIsActive() != null)
          existingAccount.setActive(accountRequestDto.getIsActive());
      if (accountRequestDto.getClientId() != null){
          existingAccount.setClientId(accountRequestDto.getClientId());
      }
      accountService.update(existingAccount);
      return AccountMapper.MAPPER.domainToData(existingAccount);
    }

    @Override
    public void deleteById(Long id) {
      Account account = getAccountById(id);
      accountService.delete(account);
    }

    private Account getAccountById(Long id) {
       return accountService.getById(id)
                .orElseThrow(() -> new BusinessException(MessageResponse.ACCOUNT_NOT_EXIST));
    }

    private Client CheckIfClientExistById(Long id) {
      return accountService.getClientById(id)
              .orElseThrow(() -> new BusinessException(MessageResponse.CLIENT_NOT_EXIST));
    }

    private void CheckIfAccountExistByNumber(String number) {

       Optional<Account> clientOptional = accountService.getAccountByNumber(number);
      if (clientOptional.isPresent()) {
          throw new BusinessException(MessageResponse.ACCOUNT_EXIST);
      }
    }

}

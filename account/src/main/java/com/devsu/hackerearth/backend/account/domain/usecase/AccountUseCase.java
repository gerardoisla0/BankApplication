package com.devsu.hackerearth.backend.account.domain.usecase;

import java.util.List;

import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.AccountResponseDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.AccountRequestDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.PartialAccountRequestDto;

public interface AccountUseCase {
    public List<AccountResponseDto> getAll();
	public AccountResponseDto getById(Long id);
	public AccountResponseDto create(AccountRequestDto accountRequestDto);
	public AccountResponseDto update(Long id, AccountRequestDto accountRequestDto);
	public AccountResponseDto partialUpdate(Long id, PartialAccountRequestDto accountRequestDto);
	public void deleteById(Long id);
}
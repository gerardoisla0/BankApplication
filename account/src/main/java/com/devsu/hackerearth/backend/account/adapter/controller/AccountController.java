package com.devsu.hackerearth.backend.account.adapter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.AccountResponseDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.AccountRequestDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.PartialAccountRequestDto;
import com.devsu.hackerearth.backend.account.domain.usecase.AccountUseCase;
import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.account.config.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

	private final AccountUseCase accountUseCase;

	@GetMapping
	public ResponseEntity<ApiResponse<List<AccountResponseDto>>> getAll() {
		List<AccountResponseDto> listAccount = accountUseCase.getAll();
		ApiResponse<List<AccountResponseDto>> response = new ApiResponse<>(listAccount, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<AccountResponseDto>> get(@PathVariable Long id) {
		AccountResponseDto account = accountUseCase.getById(id);
		ApiResponse<AccountResponseDto> response = new ApiResponse<>(account, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	public ResponseEntity<ApiResponse<AccountResponseDto>> create(
			@Valid @RequestBody AccountRequestDto accountRequestDto) {
		AccountResponseDto account = accountUseCase.create(accountRequestDto);
		ApiResponse<AccountResponseDto> response = new ApiResponse<>(account, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<AccountResponseDto>> update(@PathVariable Long id,
			@Valid @RequestBody AccountRequestDto accountRequestDto) {
		AccountResponseDto account = accountUseCase.update(id, accountRequestDto);
		ApiResponse<AccountResponseDto> response = new ApiResponse<>(account, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ApiResponse<AccountResponseDto>> partialUpdate(@PathVariable Long id,
			@Valid @RequestBody PartialAccountRequestDto partialAccountRequestDto) {
		AccountResponseDto account = accountUseCase.partialUpdate(id, partialAccountRequestDto);
		ApiResponse<AccountResponseDto> response = new ApiResponse<>(account, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		accountUseCase.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}

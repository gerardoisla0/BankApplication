package com.devsu.hackerearth.backend.account.adapter.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.BankStatementResponseDto;
import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.TransactionResponseDto;
import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.account.config.response.ApiResponse;
import com.devsu.hackerearth.backend.account.adapter.controller.model.inbound.TransactionRequestDto;
import com.devsu.hackerearth.backend.account.domain.usecase.ReportUseCase;
import com.devsu.hackerearth.backend.account.domain.usecase.TransactionUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    
    private final TransactionUseCase transactionUseCase;
	private final ReportUseCase reportUseCase;

	@GetMapping
    public ResponseEntity<ApiResponse<List<TransactionResponseDto>>> getAll(){
		List<TransactionResponseDto> listTransaction = transactionUseCase.getAll();
		ApiResponse<List<TransactionResponseDto>> response = new ApiResponse<>(listTransaction, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TransactionResponseDto>> get(@PathVariable Long id){
		TransactionResponseDto transaction = transactionUseCase.getById(id);
		ApiResponse<TransactionResponseDto> response = new ApiResponse<>(transaction, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<TransactionResponseDto>> create(@RequestBody @Valid TransactionRequestDto transactionDto){
		TransactionResponseDto transaction = transactionUseCase.create(transactionDto);
		ApiResponse<TransactionResponseDto> response = new ApiResponse<>(transaction, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/clients/{clientId}/report")
    public ResponseEntity<ApiResponse<BankStatementResponseDto>> report(@PathVariable Long clientId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTransactionStart, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTransactionEnd) {
		BankStatementResponseDto report = reportUseCase.getAllByAccountClientIdAndDateBetween(clientId, dateTransactionStart, dateTransactionEnd);
		ApiResponse<BankStatementResponseDto> response = new ApiResponse<>(report, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}

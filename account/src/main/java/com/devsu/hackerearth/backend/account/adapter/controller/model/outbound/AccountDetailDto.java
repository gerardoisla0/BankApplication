package com.devsu.hackerearth.backend.account.adapter.controller.model.outbound;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailDto {

	private String accountNumber;
	private String accountType;
	private double balance;
	private boolean isActive;
	private List<TransactionDetailDto> transactions;
}
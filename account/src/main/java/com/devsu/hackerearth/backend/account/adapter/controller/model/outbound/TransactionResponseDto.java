package com.devsu.hackerearth.backend.account.adapter.controller.model.outbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDto {
    private Long id;
    private String date;
	private String type;
	private double amount;
	private double balance;
	private Long accountId;
}

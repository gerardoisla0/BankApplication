package com.devsu.hackerearth.backend.account.adapter.controller.model.inbound;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.devsu.hackerearth.backend.account.config.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {
	@NotNull(message = "Transaction date is required")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$", message = "The date format must be yyyy-MM-dd HH:mm:ss")
	private String date;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Transaction type is required")
	private TransactionType type;
	@NotNull(message = "Transaction amount is required")
	private double amount;
	@NotNull(message = "Account ID is required")
	private Long accountId;
}

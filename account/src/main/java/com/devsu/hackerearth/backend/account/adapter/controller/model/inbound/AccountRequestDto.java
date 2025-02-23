package com.devsu.hackerearth.backend.account.adapter.controller.model.inbound;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.devsu.hackerearth.backend.account.config.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {

	@NotNull(message = "The account number is required")
	private String number;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "The account type is required")
	private AccountType type;
	@NotNull(message = "The initial amount is required")
	private double initialAmount;
	@NotNull(message = "The account status is required")
	private boolean active;
	@NotNull(message = "The client ID is required")
	private Long clientId;
}

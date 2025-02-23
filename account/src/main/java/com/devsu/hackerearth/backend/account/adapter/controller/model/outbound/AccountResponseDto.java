package com.devsu.hackerearth.backend.account.adapter.controller.model.outbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {
    private Long id;
	private String number;
	private String type;
	private double initialAmount;
	private boolean active;
	private Long clientId;
}

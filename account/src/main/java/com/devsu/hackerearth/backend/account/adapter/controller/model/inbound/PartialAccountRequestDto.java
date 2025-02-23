package com.devsu.hackerearth.backend.account.adapter.controller.model.inbound;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PartialAccountRequestDto {

	private String number;
	private String type;
	private Double initialAmount;
	private Boolean isActive;
	@NotNull(message = "The client ID is required")
	private Long clientId;
}

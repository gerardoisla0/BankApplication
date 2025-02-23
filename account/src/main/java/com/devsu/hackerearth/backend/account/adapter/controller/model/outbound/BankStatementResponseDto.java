package com.devsu.hackerearth.backend.account.adapter.controller.model.outbound;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankStatementResponseDto {

	private Long clientId;
	private Date dateReport;
	private String clientName;
	private String clientDni;
	private List<AccountDetailDto> accounts;
}
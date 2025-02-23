package com.devsu.hackerearth.backend.account.domain.usecase;

import java.util.Date;

import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.BankStatementResponseDto;

public interface ReportUseCase {
    public BankStatementResponseDto getAllByAccountClientIdAndDateBetween(Long clientId, Date dateTransactionStart, Date dateTransactionEnd);
}

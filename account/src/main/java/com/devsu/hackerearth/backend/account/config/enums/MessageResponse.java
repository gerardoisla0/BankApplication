package com.devsu.hackerearth.backend.account.config.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public enum MessageResponse {

    SUCCESS(200, "Operation completed successfully"),
    ACCOUNT_NOT_EXIST(422, "The specified account does not exist"),
    ACCOUNT_EXIST(422, "An account with the given details already exists"),
    CLIENT_NOT_EXIST(422, "The specified client does not exist"),
    PERSON_NOT_EXIST(422, "The specified person does not exist"),
    TRANSACTION_NOT_EXIST(422, "The requested transaction does not exist"),
    INSUFFICIENT_BALANCE(422, "Insufficient balance to complete the transaction"),
    ERROR_TRANSACTION_TYPE(400, "The transaction type must be DEPOSIT or WITHDRAWAL."),
    ERROR_ACCOUNT_TYPE(400, "The account type must be SAVINGS or CHECKING.");

    private final int code;
    private final String description;
}

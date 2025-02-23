package com.devsu.hackerearth.backend.client.config.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public enum MessageResponse{
    
    SUCCESS(200, "Operation completed successfully"),
    CLIENT_NOT_EXIST(422, "The specified Client does not exist"),
    CLIENT_EXIST(422, "A Client with the given details already exists");
    private final int code;
    private final String description;
}

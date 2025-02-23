package com.devsu.hackerearth.backend.account.config.response;

import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private int statusCode;
    private String statusMessage;
    private T data;

    public ApiResponse(T data, MessageResponse messageResponse){
        this.statusCode = messageResponse.getCode();
        this.statusMessage = messageResponse.getDescription();
        this.data = data;
    }
}

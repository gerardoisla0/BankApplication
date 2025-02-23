package com.devsu.hackerearth.backend.client.config.response;

import com.devsu.hackerearth.backend.client.config.enums.MessageResponse;

import lombok.Data;

@Data
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

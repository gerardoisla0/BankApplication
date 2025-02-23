package com.devsu.hackerearth.backend.account.config.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.devsu.hackerearth.backend.account.config.enums.MessageResponse;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "business error")
@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final MessageResponse code;
    
    public BusinessException(MessageResponse code){
        super("El usuario que intenta realizar la petición no es valido");
        this.code = code;
    }

    public MessageResponse getCode(){
        return code;
    }
}
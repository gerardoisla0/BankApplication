package com.devsu.hackerearth.backend.client.config.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerRestController {
    
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> exception(Exception exception){
        log.error("[Controller][Error] Ocurrio un error durante la ejecución :", exception);
        return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> BusinessException(BusinessException exception){
        log.error("[Controller][Error] Ocurrio un error durante la ejecución :", exception);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(MessageError.builder()
                    .statusCode(exception.getCode().getCode())
                    .statusMessage(exception.getCode().getDescription())
                    .build());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> BusinessException(MethodArgumentNotValidException exception){
        log.error("[Controller][Error] Ocurrio un error en los parámetros de entrada :", exception);
        StringBuilder errorsMessage = new StringBuilder();
        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errorsMessage.append(fieldName).append(": ").append(message).append("; ");
        }

        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(MessageError.builder()
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .statusMessage(errorsMessage.toString())
                    .build());
    }

    @Builder
    @Data
    static class MessageError{
        private int statusCode;
        private String statusMessage;
    }
}

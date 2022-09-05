package com.sigabem.fretecargas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class DefaultExceptionResponse {
    
    private final String name;
    private final String description;
    private final Integer statusCode;
    private final HttpStatus status;

    public DefaultExceptionResponse(Exception ex,HttpStatus status){
        this.name = ex.getClass().getSimpleName();
        this.description = ex.getMessage();
        this.status=status;
        this.statusCode=status.value();
    }

    public DefaultExceptionResponse(BindException ex,HttpStatus status){
        this.name = ex.getClass().getSimpleName();
        this.description = ex.getBindingResult().getFieldError().getDefaultMessage();
        this.status=status;
        this.statusCode=status.value();
    }

    public DefaultExceptionResponse(ResponseStatusException ex){
        this.name = ex.getClass().getSimpleName();
        this.description = ex.getReason();
        this.status= ex.getStatus();
        this.statusCode = ex.getStatus().value();
    }
}

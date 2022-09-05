package com.sigabem.fretecargas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ResponseBody
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<DefaultExceptionResponse> handleAllResponseStatusException(ResponseStatusException ex){
        var response = new DefaultExceptionResponse(ex);
        return new ResponseEntity<>(response,response.getStatus());
    }

    @Override
    public ResponseEntity<Object> handleBindException(BindException ex,HttpHeaders headers,
    HttpStatus status,
    WebRequest request){
        var response = new DefaultExceptionResponse(ex,HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(response,response.getStatus());
    }

}
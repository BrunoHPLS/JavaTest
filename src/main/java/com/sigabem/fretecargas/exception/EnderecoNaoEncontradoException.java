package com.sigabem.fretecargas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EnderecoNaoEncontradoException extends ResponseStatusException{

    public EnderecoNaoEncontradoException(String cep){
        super(
            HttpStatus.NOT_FOUND, 
            String.format("Endereço referente ao CEP '%s' não encontrado",cep));
    }
}

package com.sigabem.fretecargas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sigabem.fretecargas.exception.EnderecoNaoEncontradoException;
import com.sigabem.fretecargas.model.dto.EnderecoDto;

import reactor.core.publisher.Mono;

@Service
public class ConsultaCepService {

    @Value("${viacep.url}")
    private String viacepUrl;

    public EnderecoDto consultaCep(String CEP){
        WebClient webClient = 
            WebClient.builder()
            .baseUrl(viacepUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
        Mono<EnderecoDto> enderecoMono = 
            webClient.method(HttpMethod.GET)
            .uri("{CEP}/json/",CEP)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<>() { 
            });

        var endereco = enderecoMono.block();

        if(Optional.ofNullable(endereco.getErro()).isPresent()) throw new EnderecoNaoEncontradoException(CEP);
            
        return endereco;
    }
}

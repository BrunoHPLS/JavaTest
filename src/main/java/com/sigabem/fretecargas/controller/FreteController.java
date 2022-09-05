package com.sigabem.fretecargas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigabem.fretecargas.model.dto.FreteRequestDto;
import com.sigabem.fretecargas.model.dto.FreteResponseDto;
import com.sigabem.fretecargas.service.FreteService;

@RestController
@RequestMapping("/frete")
public class FreteController {

    @Autowired
    private FreteService service;
    
    @GetMapping(name = "Consulta Frete",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FreteResponseDto> get(
        @Valid FreteRequestDto requestDto
    ){
        return ResponseEntity.ok(
            service.consultaFrete(requestDto)
        );
    }
}

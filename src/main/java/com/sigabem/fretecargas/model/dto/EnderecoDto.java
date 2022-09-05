package com.sigabem.fretecargas.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    private String cep;
    private String uf;
    private String ddd;

    @JsonInclude(Include.NON_NULL)
    private Boolean erro;
}

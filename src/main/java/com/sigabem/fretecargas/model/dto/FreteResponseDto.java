package com.sigabem.fretecargas.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sigabem.fretecargas.utils.ValorSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreteResponseDto {
 
    @JsonSerialize(using = ValorSerializer.class)
    private BigDecimal vlTotalFrete;
    
    @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate dataPrevistaEntrega;
    private String cepOrigem;
    private String cepDestino;
}

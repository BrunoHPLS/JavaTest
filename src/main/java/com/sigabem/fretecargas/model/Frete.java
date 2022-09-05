package com.sigabem.fretecargas.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sigabem.fretecargas.model.dto.FreteRequestDto;
import com.sigabem.fretecargas.model.dto.FreteResponseDto;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_frete")
public class Frete {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFrete;
    private BigDecimal peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private BigDecimal vlTotalFrete;
    private LocalDate dataPrevistaEntrega;
    private LocalDateTime dataConsulta;

    public Frete(FreteRequestDto requestDto,FreteResponseDto responseDto){
        this.peso = requestDto.getPeso();
        this.cepOrigem = requestDto.getCepOrigem();
        this.cepDestino = requestDto.getCepDestino();
        this.nomeDestinatario = requestDto.getNomeDestinatario();
        this.vlTotalFrete = responseDto.getVlTotalFrete();
        this.dataPrevistaEntrega = responseDto.getDataPrevistaEntrega();
        this.dataConsulta = LocalDateTime.now();
    }
}

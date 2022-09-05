package com.sigabem.fretecargas.model.regra;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.sigabem.fretecargas.model.dto.EnderecoDto;
import com.sigabem.fretecargas.model.dto.FreteResponseDto;

public abstract class RegraCalculo {
    private RegraCalculo next;

    public RegraCalculo linkWith(RegraCalculo next){
        this.next = next;
        return next;
    }

    public abstract FreteResponseDto check(BigDecimal peso,EnderecoDto enderecoOrigem,EnderecoDto enderecoDestino);
    
    protected FreteResponseDto checkNext(BigDecimal peso,EnderecoDto enderecoOrigem,EnderecoDto enderecoDestino){
        return next.check(peso,enderecoOrigem,enderecoDestino);
    }

    protected BigDecimal calculaFrete(BigDecimal peso, Integer porcentagem){
        return 
            peso
            .multiply(
                new BigDecimal((double) porcentagem/100))
                .setScale(2, RoundingMode.FLOOR);
    }

    protected BigDecimal calculaFrete(BigDecimal peso){
        return peso.setScale(2,RoundingMode.FLOOR);
    }
}

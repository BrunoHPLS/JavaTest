package com.sigabem.fretecargas.model.regra;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sigabem.fretecargas.model.dto.EnderecoDto;
import com.sigabem.fretecargas.model.dto.FreteResponseDto;

public class RegraCepComDDDIgual extends RegraCalculo{

    @Override
    public FreteResponseDto check(BigDecimal peso,EnderecoDto enderecoOrigem,EnderecoDto enderecoDestino) {
        
        if(enderecoOrigem.getDdd().equals(enderecoDestino.getDdd())){
            return new FreteResponseDto(
                calculaFrete(peso, 50),
                LocalDate.now().plusDays(1),
                enderecoOrigem.getCep(),
                enderecoDestino.getCep()
            );
        }

        return checkNext(peso,enderecoOrigem,enderecoDestino);
    }
    
}

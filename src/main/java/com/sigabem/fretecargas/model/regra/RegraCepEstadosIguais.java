package com.sigabem.fretecargas.model.regra;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sigabem.fretecargas.model.dto.EnderecoDto;
import com.sigabem.fretecargas.model.dto.FreteResponseDto;

public class RegraCepEstadosIguais extends RegraCalculo{

    @Override
    public FreteResponseDto check(BigDecimal peso,EnderecoDto enderecoOrigem,EnderecoDto enderecoDestino) {
        
        if(enderecoOrigem.getUf().equals(enderecoDestino.getUf())){
            return new FreteResponseDto(
                calculaFrete(peso, 75),
                LocalDate.now().plusDays(3),
                enderecoOrigem.getCep(),
                enderecoDestino.getCep()
            );
        }

        return checkNext(peso,enderecoOrigem,enderecoDestino);
    }
    
}

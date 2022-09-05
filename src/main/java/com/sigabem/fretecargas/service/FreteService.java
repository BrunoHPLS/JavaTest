package com.sigabem.fretecargas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigabem.fretecargas.model.Frete;
import com.sigabem.fretecargas.model.dto.FreteRequestDto;
import com.sigabem.fretecargas.model.dto.FreteResponseDto;
import com.sigabem.fretecargas.model.regra.RegraCalculo;
import com.sigabem.fretecargas.model.regra.RegraCepComDDDIgual;
import com.sigabem.fretecargas.model.regra.RegraCepDiferente;
import com.sigabem.fretecargas.model.regra.RegraCepEstadosIguais;
import com.sigabem.fretecargas.repository.FreteRepository;

@Service
public class FreteService {

    @Autowired
    private ConsultaCepService consultaCepService;

    @Autowired
    private FreteRepository repository;
    
    @Transactional
    public FreteResponseDto consultaFrete(FreteRequestDto request){

        var regraCalculoChain = buildChain();

        var enderecoOrigem = consultaCepService.consultaCep(request.getCepOrigem());
        var enderecoDestino = consultaCepService.consultaCep(request.getCepDestino());

        var response = regraCalculoChain.check(request.getPeso(), enderecoOrigem, enderecoDestino);

        saveFrete(request, response);

        return response;
    }

    private RegraCalculo buildChain(){
        RegraCalculo regraCalculo = new RegraCepComDDDIgual();
        regraCalculo
        .linkWith(new RegraCepEstadosIguais())
        .linkWith(new RegraCepDiferente());
        return regraCalculo;
    }

    private void saveFrete(FreteRequestDto request,FreteResponseDto response){
        repository.save(
            new Frete(request,response)
        );
    }
    
}

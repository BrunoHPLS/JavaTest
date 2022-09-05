package com.sigabem.fretecargas.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreteRequestDto {

    @Min(value = (long) 0.01, message = "A carga deve possuir no mínimo 10 gramas")
    @Max(value = 40, message = "A carga deve possuir no máximo 40 quilogramas")
    private BigDecimal peso;

    @NotEmpty(message = "O CEP de origem não pode estar vazio")
    @Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "O cep deve seguir o padrão XXXXX-XXX")
    private String cepOrigem;

    @NotEmpty(message = "O CEP de destino não pode estar vazio")
    @Pattern(regexp = "[0-9]{5}-[0-9]{3}", message = "O cep deve seguir o padrão XXXXX-XXX")
    private String cepDestino;

    @NotEmpty(message = "O nome do destinatário não pode estar vazio")
    private String nomeDestinatario;
}

package com.desafioprojuris.apirest.ordemservico.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrdemServicoRequest {


    @NotNull(message = "id do cliente deve ser informado")
    private long clienteId;

    @NotNull(message = "id do equipamento deve ser informado")
    private long equipamentoId;

}

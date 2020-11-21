package com.desafioprojuris.apirest.atendimento.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AtendimentoCreateRequest {

    @NotNull(message = "id da ordem de serviço deve ser informada")
    private long ordemServicoId;

    @NotNull(message = "id do responsável deve ser informado")
    private long responsavelId;

    private String observacao;

}

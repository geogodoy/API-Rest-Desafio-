package com.desafioprojuris.apirest.ordemservico.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrdemServicoCreateRequest {

    @NotNull(message = "id do equipamento deve ser informado")
    private long equipamentoId;

    @NotNull(message = "id do responsável deve ser informado")
    private long responsavelId;

    private String observacao;

}

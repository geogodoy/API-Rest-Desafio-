package com.desafioprojuris.apirest.ordemservico.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrdemServicoCreateRequest {

    private long equipamentoId;
    private long responsavelId;
    private String observacao;

}

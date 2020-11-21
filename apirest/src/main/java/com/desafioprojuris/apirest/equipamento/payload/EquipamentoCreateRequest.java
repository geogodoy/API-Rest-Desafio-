package com.desafioprojuris.apirest.equipamento.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EquipamentoCreateRequest {

    @NotNull(message = "id do cliente deve ser informado")
    private long clienteId;

    private String tipo;
    private String marca;
    private String descricaoProblema;
}

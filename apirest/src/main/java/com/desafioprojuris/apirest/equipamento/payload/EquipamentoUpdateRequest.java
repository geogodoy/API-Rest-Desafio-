package com.desafioprojuris.apirest.equipamento.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentoUpdateRequest {

    private String tipo;
    private String marca;
    private String descricaoProblema;
}

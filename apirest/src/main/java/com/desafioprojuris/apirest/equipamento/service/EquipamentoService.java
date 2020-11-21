package com.desafioprojuris.apirest.equipamento.service;

import com.desafioprojuris.apirest.equipamento.Equipamento;
import com.desafioprojuris.apirest.equipamento.payload.EquipamentoCreateRequest;
import com.desafioprojuris.apirest.equipamento.payload.EquipamentoUpdateRequest;

public interface EquipamentoService {

    Equipamento createEquipamento(EquipamentoCreateRequest equipamentoCreateRequest);

    Equipamento updateEquipamento(Equipamento equipamento, EquipamentoUpdateRequest equipamentoUpdateRequest);

    Equipamento findEquipamento(long id);
}

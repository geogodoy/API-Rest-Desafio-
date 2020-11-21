package com.desafioprojuris.apirest.equipamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EquipamentoNotFoundException extends RuntimeException {

    public EquipamentoNotFoundException(long equipamentoId) {
        super(String.format("O equipamento '%d' não foi encontrado", equipamentoId));
    }

}

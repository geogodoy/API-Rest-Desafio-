package com.desafioprojuris.apirest.atendimento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtendimentoNotFoundExcpetion extends RuntimeException {

    public AtendimentoNotFoundExcpetion(long atendimentoId) {
        super(String.format("O atendimento '%d' não foi encontrado", atendimentoId));
    }

}
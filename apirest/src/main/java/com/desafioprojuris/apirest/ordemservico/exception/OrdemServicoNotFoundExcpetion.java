package com.desafioprojuris.apirest.ordemservico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrdemServicoNotFoundExcpetion extends RuntimeException {

    public OrdemServicoNotFoundExcpetion(long ordemServicoId) {
        super(String.format("A ordem de serviço '%d' não foi encontrada", ordemServicoId));
    }

}
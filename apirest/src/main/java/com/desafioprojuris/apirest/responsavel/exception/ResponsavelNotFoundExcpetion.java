package com.desafioprojuris.apirest.responsavel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResponsavelNotFoundExcpetion extends RuntimeException {

    public ResponsavelNotFoundExcpetion(long responsavelId) {
        super(String.format("O responsavel '%d' não foi encontrado", responsavelId));
    }

}
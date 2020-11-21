package com.desafioprojuris.apirest.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(long clienteId) {
        super(String.format("O cliente '%d' não foi encontrado", clienteId));
    }

}

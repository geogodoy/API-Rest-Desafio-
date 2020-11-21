package com.desafioprojuris.apirest.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteEmailAlreadyExistException extends RuntimeException {

    public ClienteEmailAlreadyExistException(String email) {
        super(String.format("O email '%s' já existe", email));
    }

}

package com.desafioprojuris.apirest.cliente.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ClienteCreateRequest {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
}

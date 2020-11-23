package com.desafioprojuris.apirest.cliente.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ClienteUpdateRequest {

    private String nome;
    private String endereco;
    private String telefone;
}

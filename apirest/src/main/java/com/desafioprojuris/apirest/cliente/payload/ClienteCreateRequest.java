package com.desafioprojuris.apirest.cliente.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ClienteCreateRequest {

    @NotBlank(message = "nome deve ser informado")
    private String nome;

    private String endereco;

    @NotBlank(message = "telefone deve ser informada")
    private String telefone;

    @NotBlank(message = "e-mail deve ser informado")
    private String email;
}

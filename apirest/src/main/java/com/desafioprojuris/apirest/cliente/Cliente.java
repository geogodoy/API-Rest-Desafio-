package com.desafioprojuris.apirest.cliente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="CLIENTE")
public class Cliente {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    @SequenceGenerator(name = "cliente", sequenceName = "s_cliente", allocationSize = 1)
    private long id;

    private String nome;
    private String endereco;
    private String telefone;
    private String email;

}

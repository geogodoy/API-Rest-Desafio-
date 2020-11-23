package com.desafioprojuris.apirest.responsavel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="RESPONSAVEL")
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "responsavel")
    @SequenceGenerator(name = "responsavel", sequenceName = "s_responsavel", allocationSize = 1)
    private long id;

    private String nome;

    private String matricula;
}

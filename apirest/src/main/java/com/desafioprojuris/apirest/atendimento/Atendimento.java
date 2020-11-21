package com.desafioprojuris.apirest.atendimento;

import com.desafioprojuris.apirest.ordemservico.OrdemServico;
import com.desafioprojuris.apirest.responsavel.Responsavel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="ATENDIMENTO")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimento")
    @SequenceGenerator(name = "atendimento", sequenceName = "s_atendimento", allocationSize = 1)
    private long id;

    @ManyToOne
    private OrdemServico ordemServico;

    @ManyToOne
    private Responsavel responsavel;

    private LocalDateTime inicioAtendimento;
    private LocalDateTime finalAtendimento;
    private String status;
    private String observacao;
}

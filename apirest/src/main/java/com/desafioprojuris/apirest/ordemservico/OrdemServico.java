package com.desafioprojuris.apirest.ordemservico;

import com.desafioprojuris.apirest.equipamento.Equipamento;
import com.desafioprojuris.apirest.responsavel.Responsavel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="ORDEM_SERVICO")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordemServico")
    @SequenceGenerator(name = "ordemServico", sequenceName = "s_ordem_servico", allocationSize = 1)
    private long id;

    @ManyToOne
    private Equipamento equipamento;

    @ManyToOne
    private Responsavel responsavel;

    private LocalDateTime inicioAtendimento;
    private LocalDateTime finalAtendimento;
    private String status;
    private String observacao;
}

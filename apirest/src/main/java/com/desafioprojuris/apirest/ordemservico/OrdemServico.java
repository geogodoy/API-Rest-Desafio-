package com.desafioprojuris.apirest.ordemservico;

import com.desafioprojuris.apirest.cliente.Cliente;
import com.desafioprojuris.apirest.equipamento.Equipamento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private Cliente cliente;

    @ManyToOne
    private Equipamento equipamento;

}

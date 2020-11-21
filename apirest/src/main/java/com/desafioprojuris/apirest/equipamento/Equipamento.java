package com.desafioprojuris.apirest.equipamento;

import com.desafioprojuris.apirest.cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="EQUIPAMENTO")
public class Equipamento {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipamento")
    @SequenceGenerator(name = "equipamento", sequenceName = "s_equipamento", allocationSize = 1)
    private long id;

    @ManyToOne
    private Cliente cliente;

    private String tipo;
    private String marca;
    private String descricaoProblema;
}

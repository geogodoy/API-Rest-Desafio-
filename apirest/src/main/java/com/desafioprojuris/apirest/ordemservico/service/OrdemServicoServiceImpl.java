package com.desafioprojuris.apirest.ordemservico.service;

import com.desafioprojuris.apirest.cliente.Cliente;
import com.desafioprojuris.apirest.cliente.service.ClienteService;
import com.desafioprojuris.apirest.equipamento.Equipamento;
import com.desafioprojuris.apirest.equipamento.service.EquipamentoService;
import com.desafioprojuris.apirest.ordemservico.OrdemServico;
import com.desafioprojuris.apirest.ordemservico.OrdemServicoRepository;
import com.desafioprojuris.apirest.ordemservico.exception.OrdemServicoNotFoundExcpetion;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService{

    @Autowired
    OrdemServicoRepository ordemServicoRepository;
    ClienteService clienteService;
    EquipamentoService equipamentoService;

    public OrdemServicoServiceImpl(OrdemServicoRepository ordemServicoRepository,
                                   ClienteService clienteService,
                                   EquipamentoService equipamentoService){
        this.ordemServicoRepository = ordemServicoRepository;
        this.clienteService = clienteService;
        this.equipamentoService = equipamentoService;
    }

    @Override
    public OrdemServico createOrdemServico(OrdemServicoRequest ordemServicoRequest) {

        Equipamento equipamento = equipamentoService.findEquipamento(ordemServicoRequest.getEquipamentoId());

        Cliente cliente = clienteService.findCliente(ordemServicoRequest.getClienteId());

        OrdemServico ordemServico = new OrdemServico();

        ordemServico.setCliente(cliente);
        ordemServico.setEquipamento(equipamento);

        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public OrdemServico findOrdemServico(long id){
    OrdemServico ordemServico = ordemServicoRepository.findById(id);

        if(ordemServico == null) {
            throw new OrdemServicoNotFoundExcpetion(id);
        }else{
            return ordemServico;
        }
    }

}

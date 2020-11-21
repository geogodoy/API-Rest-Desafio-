package com.desafioprojuris.apirest.equipamento.service;

import com.desafioprojuris.apirest.cliente.Cliente;
import com.desafioprojuris.apirest.cliente.service.ClienteService;
import com.desafioprojuris.apirest.equipamento.Equipamento;
import com.desafioprojuris.apirest.equipamento.EquipamentoRepository;
import com.desafioprojuris.apirest.equipamento.exception.EquipamentoNotFoundException;
import com.desafioprojuris.apirest.equipamento.payload.EquipamentoCreateRequest;
import com.desafioprojuris.apirest.equipamento.payload.EquipamentoUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoServiceImpl implements EquipamentoService{

    @Autowired
    EquipamentoRepository equipamentoRepository;
    ClienteService clienteService;

    public EquipamentoServiceImpl(EquipamentoRepository equipamentoRepository,
                                  ClienteService clienteService){
        this.equipamentoRepository = equipamentoRepository;
        this.clienteService = clienteService;
    }

    @Override
    public Equipamento createEquipamento(EquipamentoCreateRequest equipamentoCreateRequest) {
        Cliente cliente = clienteService.findCliente(equipamentoCreateRequest.getClienteId());

        Equipamento equipamento = new Equipamento();

        equipamento.setCliente(cliente);
        equipamento.setTipo(equipamentoCreateRequest.getTipo());
        equipamento.setMarca(equipamentoCreateRequest.getMarca());
        equipamento.setDescricaoProblema(equipamentoCreateRequest.getDescricaoProblema());

        return equipamentoRepository.save(equipamento);
    }

    @Override
    public Equipamento updateEquipamento(Equipamento equipamento, EquipamentoUpdateRequest equipamentoUpdateRequest) {

        equipamento.setTipo(equipamentoUpdateRequest.getTipo());
        equipamento.setMarca(equipamentoUpdateRequest.getMarca());
        equipamento.setDescricaoProblema(equipamentoUpdateRequest.getDescricaoProblema());

        return equipamentoRepository.save(equipamento);
    }

    @Override
    public Equipamento findEquipamento(long id) {

        Equipamento equipamento = equipamentoRepository.findById(id);

        if(equipamento == null) {
            throw new EquipamentoNotFoundException(id);
        }else{
            return equipamento;
        }
    }
}

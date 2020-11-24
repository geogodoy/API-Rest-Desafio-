package com.desafioprojuris.apirest.ordemservico.service;

import com.desafioprojuris.apirest.equipamento.Equipamento;
import com.desafioprojuris.apirest.equipamento.service.EquipamentoService;
import com.desafioprojuris.apirest.ordemservico.OrdemServico;
import com.desafioprojuris.apirest.ordemservico.OrdemServicoRepository;
import com.desafioprojuris.apirest.ordemservico.exception.OrdemServicoNotFoundExcpetion;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoCreateRequest;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoRequest;
import com.desafioprojuris.apirest.responsavel.Responsavel;
import com.desafioprojuris.apirest.responsavel.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    OrdemServicoRepository ordemServicoRepository;
    EquipamentoService equipamentoService;
    ResponsavelService responsavelService;

    public OrdemServicoServiceImpl(OrdemServicoRepository ordemServicoRepository,
                                   EquipamentoService equipamentoService,
                                   ResponsavelService responsavelService){
        this.ordemServicoRepository = ordemServicoRepository;
        this.equipamentoService = equipamentoService;
        this.responsavelService = responsavelService;
    }

    @Override
    public OrdemServico createOrdemServico(OrdemServicoCreateRequest ordemServicoCreateRequest) {
        Equipamento equipamento = equipamentoService.findEquipamento(ordemServicoCreateRequest.getEquipamentoId());

        Responsavel responsavel = responsavelService.findResponsavel(ordemServicoCreateRequest.getResponsavelId());

        OrdemServico ordemServico = new OrdemServico();

        ordemServico.setEquipamento(equipamento);
        ordemServico.setResponsavel(responsavel);
        ordemServico.setStatus("PENDENTE");

        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public void startOrdemServico(OrdemServico ordemServico, OrdemServicoRequest ordemServicoRequest) {
        ordemServico.setInicioAtendimento(LocalDateTime.now());
        ordemServico.setObservacao(ordemServicoRequest.getObservacao());
        ordemServico.setStatus("INICIADO");

       ordemServicoRepository.save(ordemServico);
    }

    @Override
    public void pauseOrdemServico(OrdemServico ordemServico, OrdemServicoRequest ordemServicoRequest) {
        ordemServico.setObservacao(ordemServicoRequest.getObservacao());
        ordemServico.setStatus("PAUSADO");

        ordemServicoRepository.save(ordemServico);
    }

    @Override
    public void finishOrdemServico(OrdemServico ordemServico, OrdemServicoRequest ordemServicoRequest) {
        ordemServico.setFinalAtendimento(LocalDateTime.now());
        ordemServico.setObservacao(ordemServicoRequest.getObservacao());
        ordemServico.setStatus("FINALIZADO");

        ordemServicoRepository.save(ordemServico);
    }

    @Override
    public OrdemServico findOrdemServico(long id) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id);

        if(ordemServico == null) {
            throw new OrdemServicoNotFoundExcpetion(id);
        }else{
            return ordemServico;
        }
    }

    @Override
    public List<OrdemServico> findOrdemServicosPendenteByResponsavel(long responsavelId) {
        return ordemServicoRepository.findByStatusAndResponsavelId("PENDENTE", responsavelId );
    }

    @Override
    public List<OrdemServico> findOrdemServicosIniciadoByResponsavel(long responsavelId) {
        return ordemServicoRepository.findByStatusAndResponsavelId("INICIADO", responsavelId );
    }

    @Override
    public List<OrdemServico> findOrdemServicosPausadoByResponsavel(long responsavelId) {
        return ordemServicoRepository.findByStatusAndResponsavelId("PAUSADO", responsavelId );
    }

    @Override
    public List<OrdemServico> findOrdemServicosFinalizadoByResponsavel(long responsavelId) {
        return ordemServicoRepository.findByStatusAndResponsavelId("FINALIZADO", responsavelId );
    }

    @Override
    public List<OrdemServico> findOrdemServicosByStatusAndResponsavel(String status, long responsavelId) {
        return ordemServicoRepository.findByStatusAndResponsavelId(status, responsavelId );
    }

    @Override
    public List<OrdemServico> findOrdemServicosByStatus(String status) {
        return ordemServicoRepository.findByStatus(status);
    }

}

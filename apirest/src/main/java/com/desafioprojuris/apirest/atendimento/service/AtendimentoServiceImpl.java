package com.desafioprojuris.apirest.atendimento.service;

import com.desafioprojuris.apirest.atendimento.Atendimento;
import com.desafioprojuris.apirest.atendimento.AtendimentoRepository;
import com.desafioprojuris.apirest.atendimento.exception.AtendimentoNotFoundExcpetion;
import com.desafioprojuris.apirest.atendimento.payload.AtendimentoCreateRequest;
import com.desafioprojuris.apirest.atendimento.payload.AtendimentoRequest;
import com.desafioprojuris.apirest.ordemservico.OrdemServico;
import com.desafioprojuris.apirest.ordemservico.service.OrdemServicoService;
import com.desafioprojuris.apirest.responsavel.Responsavel;
import com.desafioprojuris.apirest.responsavel.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtendimentoServiceImpl implements AtendimentoService{

    @Autowired
    AtendimentoRepository atendimentoRepository;
    OrdemServicoService ordemServicoService;
    ResponsavelService responsavelService;

    public AtendimentoServiceImpl(AtendimentoRepository atendimentoRepository,
                                  OrdemServicoService ordemServicoService,
                                  ResponsavelService responsavelService){
        this.atendimentoRepository = atendimentoRepository;
        this.ordemServicoService = ordemServicoService;
        this.responsavelService = responsavelService;
    }

    @Override
    public Atendimento createAtendimento(AtendimentoCreateRequest atendimentoCreateRequest) {
        OrdemServico ordemServico = ordemServicoService.findOrdemServico(atendimentoCreateRequest.getOrdemServicoId());

        Responsavel responsavel = responsavelService.findResponsavel(atendimentoCreateRequest.getResponsavelId());

        Atendimento atendimento = new Atendimento();

        atendimento.setOrdemServico(ordemServico);
        atendimento.setResponsavel(responsavel);
        atendimento.setStatus("PENDENTE");

        return atendimentoRepository.save(atendimento);
    }

    @Override
    public void startAtendimento(Atendimento atendimento, AtendimentoRequest atendimentoRequest) {
        atendimento.setInicioAtendimento(LocalDateTime.now());
        atendimento.setObservacao(atendimentoRequest.getObservacao());
        atendimento.setStatus("INICIADO");

       atendimentoRepository.save(atendimento);
    }

    @Override
    public void pauseAtendimento(Atendimento atendimento, AtendimentoRequest atendimentoRequest) {
        atendimento.setObservacao(atendimentoRequest.getObservacao());
        atendimento.setStatus("PAUSADO");

        atendimentoRepository.save(atendimento);
    }

    @Override
    public void finishAtendimento(Atendimento atendimento) {
        atendimento.setFinalAtendimento(LocalDateTime.now());
        atendimento.setStatus("FINALIZADO");

        atendimentoRepository.save(atendimento);
    }

    @Override
    public Atendimento findAtendimento(long id) {
        Atendimento atendimento = atendimentoRepository.findById(id);

        if(atendimento == null) {
            throw new AtendimentoNotFoundExcpetion(id);
        }else{
            return atendimento;
        }
    }

    @Override
    public List<Atendimento> findAtendimentosPendenteByResponsavel(long responsavelId) {
        return atendimentoRepository.findByStatusAndResponsavelId("PENDENTE", responsavelId );
    }

    @Override
    public List<Atendimento> findAtendimentosIniciadoByResponsavel(long responsavelId) {
        return atendimentoRepository.findByStatusAndResponsavelId("INICIADO", responsavelId );
    }

    @Override
    public List<Atendimento> findAtendimentosPausadoByResponsavel(long responsavelId) {
        return atendimentoRepository.findByStatusAndResponsavelId("PAUSADO", responsavelId );
    }

    @Override
    public List<Atendimento> findAtendimentosFinalizadoByResponsavel(long responsavelId) {
        return atendimentoRepository.findByStatusAndResponsavelId("FINALIZADO", responsavelId );
    }

    @Override
    public List<Atendimento> findAtendimentosByStatusAndResponsavel(String status, long responsavelId) {
        return atendimentoRepository.findByStatusAndResponsavelId(status, responsavelId );
    }

    @Override
    public List<Atendimento> findAtendimentosByStatus(String status) {
        return atendimentoRepository.findByStatus(status);
    }

}

package com.desafioprojuris.apirest.atendimento.service;

import com.desafioprojuris.apirest.atendimento.Atendimento;
import com.desafioprojuris.apirest.atendimento.payload.AtendimentoCreateRequest;
import com.desafioprojuris.apirest.atendimento.payload.AtendimentoRequest;

import java.util.List;

public interface AtendimentoService {

    Atendimento createAtendimento(AtendimentoCreateRequest atendimentoCreateRequest);

    void startAtendimento(Atendimento atendimento, AtendimentoRequest atendimentoRequest);

    void pauseAtendimento(Atendimento atendimento, AtendimentoRequest atendimentoRequest);

    void finishAtendimento(Atendimento atendimento);

    Atendimento findAtendimento(long id);

    List<Atendimento> findAtendimentosPendenteByResponsavel(long responsavelId);

    List<Atendimento> findAtendimentosIniciadoByResponsavel(long responsavelId);

    List<Atendimento> findAtendimentosPausadoByResponsavel(long responsavelId);

    List<Atendimento> findAtendimentosFinalizadoByResponsavel(long responsavelId);

    List<Atendimento> findAtendimentosByStatusAndResponsavel(String status, long responsavelId);

    List<Atendimento> findAtendimentosByStatus(String status);


}

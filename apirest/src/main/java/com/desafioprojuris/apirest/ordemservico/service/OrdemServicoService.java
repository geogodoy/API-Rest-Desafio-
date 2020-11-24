package com.desafioprojuris.apirest.ordemservico.service;

import com.desafioprojuris.apirest.ordemservico.OrdemServico;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoCreateRequest;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoRequest;

import java.util.List;

public interface OrdemServicoService {

    OrdemServico createOrdemServico(OrdemServicoCreateRequest ordemServicoCreateRequest);

    void startOrdemServico(OrdemServico ordemServico, OrdemServicoRequest ordemServicoRequest);

    void pauseOrdemServico(OrdemServico ordemServico, OrdemServicoRequest ordemServicoRequest);

    void finishOrdemServico(OrdemServico ordemServico, OrdemServicoRequest ordemServicoRequest);

    OrdemServico findOrdemServico(long id);

    List<OrdemServico> findOrdemServicosPendenteByResponsavel(long responsavelId);

    List<OrdemServico> findOrdemServicosIniciadoByResponsavel(long responsavelId);

    List<OrdemServico> findOrdemServicosPausadoByResponsavel(long responsavelId);

    List<OrdemServico> findOrdemServicosFinalizadoByResponsavel(long responsavelId);

    List<OrdemServico> findOrdemServicosByStatusAndResponsavel(String status, long responsavelId);

    List<OrdemServico> findOrdemServicosByStatus(String status);


}

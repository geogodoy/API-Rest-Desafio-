package com.desafioprojuris.apirest.ordemservico.service;

import com.desafioprojuris.apirest.ordemservico.OrdemServico;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoRequest;

public interface OrdemServicoService {

    OrdemServico createOrdemServico(OrdemServicoRequest ordemServicoRequest);

    OrdemServico findOrdemServico(long id);

}

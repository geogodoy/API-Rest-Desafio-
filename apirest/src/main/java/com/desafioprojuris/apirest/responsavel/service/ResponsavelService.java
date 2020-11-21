package com.desafioprojuris.apirest.responsavel.service;

import com.desafioprojuris.apirest.responsavel.Responsavel;
import com.desafioprojuris.apirest.responsavel.payload.ResponsavelRequest;

public interface ResponsavelService {

    Responsavel createResponsavel(ResponsavelRequest responsavelRequest);

    Responsavel findResponsavel(long id);
}

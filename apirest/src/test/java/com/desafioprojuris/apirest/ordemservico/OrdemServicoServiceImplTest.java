package com.desafioprojuris.apirest.ordemservico;

import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoCreateRequest;
import com.desafioprojuris.apirest.ordemservico.service.OrdemServicoServiceImpl;
import com.desafioprojuris.apirest.ordemservico.service.OrdemServicoService;
import com.desafioprojuris.apirest.responsavel.service.ResponsavelService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrdemServicoServiceImplTest {

    @InjectMocks
    private OrdemServicoServiceImpl ordemServicoService;

    @Mock
    private OrdemServicoRepository ordemServicoRepository;


    @Mock
    private ResponsavelService responsavelService;

    @Mock
    private OrdemServico ordemServico;

    @Mock
    private OrdemServicoCreateRequest ordemServicoCreateRequest;


}

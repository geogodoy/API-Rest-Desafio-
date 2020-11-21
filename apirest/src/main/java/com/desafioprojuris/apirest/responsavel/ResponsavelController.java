package com.desafioprojuris.apirest.responsavel;


import com.desafioprojuris.apirest.ordemservico.OrdemServico;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoRequest;
import com.desafioprojuris.apirest.responsavel.payload.ResponsavelRequest;
import com.desafioprojuris.apirest.responsavel.service.ResponsavelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/desafio")
@Api(value="API REST")
@CrossOrigin(origins = "*")
public class ResponsavelController {

    @Autowired
    ResponsavelService responsavelService;

    public ResponsavelController(ResponsavelService responsavelService){
        this.responsavelService = responsavelService;
    }

    @PostMapping("/responsavel")
    @ApiOperation(value="Cria um responsável")
    public Responsavel createResponsavel(@Valid @RequestBody ResponsavelRequest responsavelRequest) {
        return responsavelService.createResponsavel(responsavelRequest);
    }
}

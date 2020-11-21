package com.desafioprojuris.apirest.ordemservico;

import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoRequest;
import com.desafioprojuris.apirest.ordemservico.service.OrdemServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/desafio")
@Api(value="API REST")
@CrossOrigin(origins = "*")
public class OrdemServicoController {

    @Autowired
    OrdemServicoService ordemServicoService;

    public OrdemServicoController(OrdemServicoService ordemServicoService){
        this.ordemServicoService = ordemServicoService;
    }

    @PostMapping("/ordem/servico")
    @ApiOperation(value="Cria uma ordem de serviço")
    public OrdemServico createOrdemServico(@Valid @RequestBody OrdemServicoRequest ordemServicoRequest) {
        return ordemServicoService.createOrdemServico(ordemServicoRequest);
    }
}

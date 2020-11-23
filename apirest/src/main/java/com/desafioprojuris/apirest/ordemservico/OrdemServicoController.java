package com.desafioprojuris.apirest.ordemservico;

import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoCreateRequest;
import com.desafioprojuris.apirest.ordemservico.payload.OrdemServicoRequest;
import com.desafioprojuris.apirest.ordemservico.service.OrdemServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public OrdemServico createOrdemServico(@Valid @RequestBody OrdemServicoCreateRequest ordemServicoCreateRequest) {
        return ordemServicoService.createOrdemServico(ordemServicoCreateRequest);
    }

    @PutMapping("/ordem/servico/start/{id}")
    @ApiOperation(value="Inicializa o atendimento da ordem de serviço")
    public void startOrdemServico(@PathVariable(value = "id") long id,
                                 @Valid @RequestBody OrdemServicoRequest ordemServicoRequest) {
        OrdemServico ordemServico = ordemServicoService.findOrdemServico(id);

        ordemServicoService.startOrdemServico(ordemServico, ordemServicoRequest);
    }

    @PutMapping("/ordem/servico/finish/{id}")
    @ApiOperation(value="Finaliza o atendimento da ordem de serviço")
    public void finishOrdemServico(@PathVariable(value = "id") long id) {
        OrdemServico ordemServico = ordemServicoService.findOrdemServico(id);

        ordemServicoService.finishOrdemServico(ordemServico);
    }

    @PutMapping("/ordem/servico/pause/{id}")
    @ApiOperation(value="Pausa o atendimento da ordem de serviço")
    public void pauseOrdemServico(@PathVariable(value = "id") long id,
                                 @Valid @RequestBody OrdemServicoRequest ordemServicoRequest) {
        OrdemServico ordemServico = ordemServicoService.findOrdemServico(id);

        ordemServicoService.pauseOrdemServico(ordemServico, ordemServicoRequest);
    }

    @GetMapping("/ordens/servicos/pendente/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de ordens de servicos pendentes por responsável")
    public List<OrdemServico> listOrdensServicosPendenteByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return ordemServicoService.findOrdemServicosPendenteByResponsavel(responsavelId);
    }

    @GetMapping("/ordens/servicos/iniciado/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de ordens de serviços iniciados por responsável")
    public List<OrdemServico> listOrdensServicosIniciadoByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return ordemServicoService.findOrdemServicosIniciadoByResponsavel(responsavelId);
    }

    @GetMapping("/ordens/servicos/pausado/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de ordens serviços pausados por responsável")
    public List<OrdemServico> listOrdensServicosPausadoByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return ordemServicoService.findOrdemServicosPausadoByResponsavel(responsavelId);
    }

    @GetMapping("/ordens/servicos/finalizado/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de ordens serviços finalizados por responsável")
    public List<OrdemServico> listOrdensServicosFinalizadoByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return ordemServicoService.findOrdemServicosFinalizadoByResponsavel(responsavelId);
    }

    @GetMapping("/ordens/servicos/{responsavelId}/{status}")
    @ApiOperation(value="Retorna uma lista de ordens de serviços por status e por responsável")
    public List<OrdemServico> listOrdensServicosByStatusAndResponsavel(@PathVariable(value = "responsavelId") long responsavelId,
                                                                     @PathVariable(value = "status") String status){

        return ordemServicoService.findOrdemServicosByStatusAndResponsavel(status, responsavelId);
    }

    @GetMapping("/ordens/servicos/{status}")
    @ApiOperation(value="Retorna uma lista de ordens de serviços por status")
    public List<OrdemServico> listOrdensServicosByStatus(@PathVariable(value = "status") String status){

        return ordemServicoService.findOrdemServicosByStatus(status);
    }
}

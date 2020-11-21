package com.desafioprojuris.apirest.atendimento;

import com.desafioprojuris.apirest.atendimento.payload.AtendimentoCreateRequest;
import com.desafioprojuris.apirest.atendimento.payload.AtendimentoRequest;
import com.desafioprojuris.apirest.atendimento.service.AtendimentoService;
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
public class AtendimentoController {

    @Autowired
    AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService){
        this.atendimentoService = atendimentoService;
    }

    @PostMapping("/atendimento")
    @ApiOperation(value="Cria um atendimento")
    public Atendimento createAtendimento(@Valid @RequestBody AtendimentoCreateRequest atendimentoCreateRequest) {
        return atendimentoService.createAtendimento(atendimentoCreateRequest);
    }

    @PutMapping("/atendimento/start/{id}")
    @ApiOperation(value="Inicializa o atendimento")
    public void startAtendimento(@PathVariable(value = "id") long id,
                                 @Valid @RequestBody AtendimentoRequest atendimentoRequest) {
        Atendimento atendimento = atendimentoService.findAtendimento(id);

        atendimentoService.startAtendimento(atendimento, atendimentoRequest);
    }

    @PutMapping("/atendimento/finish/{id}")
    @ApiOperation(value="Finaliza o atendimento")
    public void finishAtendimento(@PathVariable(value = "id") long id) {
        Atendimento atendimento = atendimentoService.findAtendimento(id);

        atendimentoService.finishAtendimento(atendimento);
    }

    @PutMapping("/atendimento/pause/{id}")
    @ApiOperation(value="Pausa o atendimento")
    public void pauseAtendimento(@PathVariable(value = "id") long id,
                                 @Valid @RequestBody AtendimentoRequest atendimentoRequest) {
        Atendimento atendimento = atendimentoService.findAtendimento(id);

        atendimentoService.pauseAtendimento(atendimento, atendimentoRequest);
    }

    @GetMapping("/atendimentos/pendente/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de atendimentos pendentes por responsável")
    public List<Atendimento> listAtendimentosPendenteByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return atendimentoService.findAtendimentosPendenteByResponsavel(responsavelId);
    }

    @GetMapping("/atendimentos/iniciado/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de atendimentos iniciados por responsável")
    public List<Atendimento> listAtendimentosIniciadoByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return atendimentoService.findAtendimentosIniciadoByResponsavel(responsavelId);
    }

    @GetMapping("/atendimentos/pausado/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de atendimentos pausados por responsável")
    public List<Atendimento> listAtendimentosPausadoByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return atendimentoService.findAtendimentosPausadoByResponsavel(responsavelId);
    }

    @GetMapping("/atendimentos/finalizado/{responsavelId}")
    @ApiOperation(value="Retorna uma lista de atendimentos finalizado por responsável")
    public List<Atendimento> listAtendimentosFinalizadoByResponsavel(@PathVariable(value = "responsavelId") long responsavelId){

        return atendimentoService.findAtendimentosFinalizadoByResponsavel(responsavelId);
    }

    @GetMapping("/atendimentos/{responsavelId}/{status}")
    @ApiOperation(value="Retorna uma lista de atendimentos por status e por responsável")
    public List<Atendimento> listAtendimentosByStatusAndResponsavel(@PathVariable(value = "responsavelId") long responsavelId,
                                                                    @PathVariable(value = "status") String status){

        return atendimentoService.findAtendimentosByStatusAndResponsavel(status, responsavelId);
    }

    @GetMapping("/atendimentos/{status}")
    @ApiOperation(value="Retorna uma lista de atendimentos por status")
    public List<Atendimento> listAtendimentosByStatus(@PathVariable(value = "status") String status){

        return atendimentoService.findAtendimentosByStatus(status);
    }
}

package com.desafioprojuris.apirest.equipamento;

import com.desafioprojuris.apirest.equipamento.payload.EquipamentoCreateRequest;
import com.desafioprojuris.apirest.equipamento.payload.EquipamentoUpdateRequest;
import com.desafioprojuris.apirest.equipamento.service.EquipamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/desafio")
@Api(value="API REST")
@CrossOrigin(origins = "*")
public class EquipamentoController {

    @Autowired
    EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService){
        this.equipamentoService = equipamentoService;
    }

    @PostMapping("/equipamento")
    @ApiOperation(value="Cria um equipamento")
    public Equipamento createEquipamento(@Valid @RequestBody EquipamentoCreateRequest equipamentoCreateRequest) {
        return equipamentoService.createEquipamento(equipamentoCreateRequest);
    }

    @PutMapping("/equipamento/{id}")
    @ApiOperation(value="Atualiza um equipamento")
    public Equipamento updateequipamentoCliente(@PathVariable(value = "id") long id,
                                 @Valid @RequestBody EquipamentoUpdateRequest equipamentoUpdateRequest) {
        Equipamento equipamento = equipamentoService.findEquipamento(id);

        return equipamentoService.updateEquipamento(equipamento, equipamentoUpdateRequest);
    }

}

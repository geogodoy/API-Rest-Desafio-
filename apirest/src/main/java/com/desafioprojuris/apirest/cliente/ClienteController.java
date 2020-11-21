package com.desafioprojuris.apirest.cliente;

import com.desafioprojuris.apirest.cliente.payload.ClienteCreateRequest;
import com.desafioprojuris.apirest.cliente.payload.ClienteUpdateRequest;
import com.desafioprojuris.apirest.cliente.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/desafio")
@Api(value="API REST")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping("/cliente")
    @ApiOperation(value="Cria um cliente")
    public Cliente createCliente(@Valid @RequestBody ClienteCreateRequest clienteCreateRequest) {
        return clienteService.createCliente(clienteCreateRequest);
    }

    @PutMapping("/cliente/{id}")
    @ApiOperation(value="atualiza um cliente")
    public Cliente updateCliente(@PathVariable(value = "id") long id,
                                 @Valid @RequestBody ClienteUpdateRequest clienteUpdateRequest) {
        Cliente cliente = clienteService.findCliente(id);

        return clienteService.updateCliente(cliente, clienteUpdateRequest);
    }

    @DeleteMapping("/cliente/{id}")
    @ApiOperation(value="delete um cliente")
    public void deleteCliente(@PathVariable(value = "id") long id) {
        Cliente cliente = clienteService.findCliente(id);
        clienteService.deleteCliente(cliente);
    }
}

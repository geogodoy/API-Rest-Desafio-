package com.desafioprojuris.apirest.cliente.service;

import com.desafioprojuris.apirest.cliente.Cliente;
import com.desafioprojuris.apirest.cliente.payload.ClienteCreateRequest;
import com.desafioprojuris.apirest.cliente.payload.ClienteUpdateRequest;

public interface ClienteService {

    Cliente createCliente(ClienteCreateRequest clienteCreateRequest);

    void deleteCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente, ClienteUpdateRequest clienteUpdateRequest);

    Cliente findCliente(long id);

}

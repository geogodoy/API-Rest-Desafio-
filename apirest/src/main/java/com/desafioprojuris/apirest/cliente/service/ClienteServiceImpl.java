package com.desafioprojuris.apirest.cliente.service;

import com.desafioprojuris.apirest.cliente.Cliente;
import com.desafioprojuris.apirest.cliente.ClienteRepository;
import com.desafioprojuris.apirest.cliente.exception.ClienteEmailAlreadyExistException;
import com.desafioprojuris.apirest.cliente.exception.ClienteNotFoundException;
import com.desafioprojuris.apirest.cliente.payload.ClienteCreateRequest;
import com.desafioprojuris.apirest.cliente.payload.ClienteUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente createCliente(ClienteCreateRequest clienteCreateRequest) {

        if(clienteRepository.findByEmail(clienteCreateRequest.getEmail()) != null){
            throw new ClienteEmailAlreadyExistException(clienteCreateRequest.getEmail());
        }

        Cliente cliente = new Cliente();

        cliente.setNome(clienteCreateRequest.getNome());
        cliente.setEndereco(clienteCreateRequest.getEndereco());
        cliente.setTelefone(clienteCreateRequest.getTelefone());
        cliente.setEmail(clienteCreateRequest.getEmail());

        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente, ClienteUpdateRequest clienteUpdateRequest) {

        cliente.setNome(clienteUpdateRequest.getNome());
        cliente.setEndereco(clienteUpdateRequest.getEndereco());
        cliente.setTelefone(clienteUpdateRequest.getTelefone());

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findCliente(long id){
        Cliente cliente = clienteRepository.findById(id);

        if(cliente == null) {
            throw new ClienteNotFoundException(id);
        }else{
            return cliente;
        }
    }
}

package com.desafioprojuris.apirest.responsavel.service;

import com.desafioprojuris.apirest.responsavel.Responsavel;
import com.desafioprojuris.apirest.responsavel.ResponsavelRepository;
import com.desafioprojuris.apirest.responsavel.exception.ResponsavelNotFoundExcpetion;
import com.desafioprojuris.apirest.responsavel.payload.ResponsavelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelServiceImpl implements ResponsavelService{

    @Autowired
    ResponsavelRepository responsavelRepository;

    public ResponsavelServiceImpl(ResponsavelRepository responsavelRepository){
        this.responsavelRepository = responsavelRepository;
    }

    @Override
    public Responsavel createResponsavel(ResponsavelRequest responsavelRequest) {
        Responsavel responsavel = new Responsavel();

        responsavel.setNome(responsavelRequest.getNome());
        responsavel.setMatricula(responsavelRequest.getMatricula());

        return responsavelRepository.save(responsavel);
    }

    @Override
    public Responsavel findResponsavel(long id) {
        Responsavel responsavel = responsavelRepository.findById(id);

        if(responsavel == null) {
            throw new ResponsavelNotFoundExcpetion(id);
        }else{
            return responsavel;
        }
    }
}

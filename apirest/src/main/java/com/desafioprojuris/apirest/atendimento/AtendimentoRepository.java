package com.desafioprojuris.apirest.atendimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>, JpaSpecificationExecutor<Atendimento> {

    Atendimento findById(long id);

    List<Atendimento> findByStatusAndResponsavelId(String status, long responsavelId);

    List<Atendimento> findByStatus(String status);
}
package com.desafioprojuris.apirest.ordemservico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>, JpaSpecificationExecutor<OrdemServico> {

    OrdemServico findById(long id);

    List<OrdemServico> findByStatusAndResponsavelId(String status, long responsavelId);

    List<OrdemServico> findByStatus(String status);
}
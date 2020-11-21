package com.desafioprojuris.apirest.equipamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>, JpaSpecificationExecutor<Equipamento> {

    Equipamento findById(long id);
}

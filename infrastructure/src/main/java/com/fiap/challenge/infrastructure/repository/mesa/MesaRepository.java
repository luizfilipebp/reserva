package com.fiap.challenge.infrastructure.repository.mesa;

import com.fiap.challenge.infrastructure.entity.mesa.MesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<MesaEntity, Long> {
}

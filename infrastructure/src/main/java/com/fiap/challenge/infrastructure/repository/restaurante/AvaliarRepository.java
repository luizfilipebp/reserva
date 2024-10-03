package com.fiap.challenge.infrastructure.repository.restaurante;

import com.fiap.challenge.infrastructure.entity.mesa.MesaEntity;
import com.fiap.challenge.infrastructure.entity.restaurante.AvaliarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliarRepository extends JpaRepository<AvaliarEntity, Long> {

}

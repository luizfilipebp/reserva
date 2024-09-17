package com.fiap.challenge.infrastructure.repository;

import com.fiap.challenge.infrastructure.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    List<ReservaEntity> findByDataHora(LocalDateTime dataHora);
}

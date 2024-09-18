package com.fiap.challenge.infrastructure.repository.reserva;

import com.fiap.challenge.infrastructure.entity.reserva.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    List<ReservaEntity> findByDataHora(LocalDateTime dataHora);
}

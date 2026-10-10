package com.carlosmelo.agendamento_horarios.infrastructure.repository;

import com.carlosmelo.agendamento_horarios.infrastructure.entity.AgendamentoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity,Long> {

    AgendamentoEntity findByServicoAndDataHoraAulaBetween(String servico,
                                                                 LocalDateTime dataHoraInicio,
                                                                 LocalDateTime dataHoraFinal);

    @Transactional
    void deleteByDataHoraAulaAndCliente(LocalDateTime dataHoraAula, String cliente);

    List<AgendamentoEntity> findByDataHoraAulaBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);

    AgendamentoEntity findByDataHoraAulaAndCliente(LocalDateTime dataHoraAula, String cliente);
}

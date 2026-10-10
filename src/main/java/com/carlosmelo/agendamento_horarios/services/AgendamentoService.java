package com.carlosmelo.agendamento_horarios.services;

import com.carlosmelo.agendamento_horarios.infrastructure.entity.AgendamentoEntity;
import com.carlosmelo.agendamento_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor //injeção de dependencias, chama dentro da class service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoEntity salvarAgendamento(AgendamentoEntity agendamento){

        LocalDateTime horaAgendamento = agendamento.getDataHoraAula();
        LocalDateTime horaFim = agendamento.getDataHoraAula();

        AgendamentoEntity agendados = agendamentoRepository.findByServicoAndDataHoraAulaBetween(agendamento.getServico(),
                                                                        horaAgendamento, horaFim);

        if(Objects.nonNull(agendados)){
            throw new RuntimeException("Horário já preenchido");
        }
        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(LocalDateTime dataHoraAula, String cliente){

        agendamentoRepository.deleteByDataHoraAulaAndCliente(dataHoraAula, cliente);
    }

    public List<AgendamentoEntity> buscarAgendamentosDia(LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay(); //primeira hora do dia
        LocalDateTime horaFinalDia = data.atTime(23,59,59); //hora final

       return agendamentoRepository.findByDataHoraAulaBetween(primeiraHoraDia, horaFinalDia);
    }

    public AgendamentoEntity alterarAgendamento(AgendamentoEntity agendamento, String cliente, LocalDateTime dataHoraAula){
        AgendamentoEntity agenda = agendamentoRepository.findByDataHoraAulaAndCliente(dataHoraAula, cliente);

        if(Objects.isNull(agenda)){
            throw new RuntimeException("Horário não preenchido");
        }
        agendamento.setId(agenda.getId());
        return agendamentoRepository.save(agendamento);

    }
}

package com.carlosmelo.agendamento_horarios.controller;

import com.carlosmelo.agendamento_horarios.infrastructure.entity.AgendamentoEntity;
import com.carlosmelo.agendamento_horarios.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoEntity> salvarAgendamento(@RequestBody AgendamentoEntity agendamento){
        return  ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente,
                                                   @RequestParam LocalDateTime dataHoraAula){

        agendamentoService.deletarAgendamento(dataHoraAula, cliente);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<AgendamentoEntity>> buscarAgendamentosDia(@RequestParam LocalDate data){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
    }

    @PutMapping
    public ResponseEntity<AgendamentoEntity> alterarAgendamentos(@RequestBody AgendamentoEntity agendamento, @RequestParam String cliente,
                                                                 @RequestParam LocalDateTime dataHoraAula){
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, cliente, dataHoraAula));
    }

}

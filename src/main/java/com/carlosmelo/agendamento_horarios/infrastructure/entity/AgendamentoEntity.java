package com.carlosmelo.agendamento_horarios.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamentos")

public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //vai gerar o id automaticamente..
    private Long id;
    private String servico;
    private String profissional;
    private LocalDateTime dataHoraAula;
    private String cliente;
    private String contatoCliente;
    private LocalDateTime dataHoraAgendada = LocalDateTime.now();
}

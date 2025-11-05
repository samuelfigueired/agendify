package com.agendify.agendamento.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name = "TB_AGENDAMENTO")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AGENDAMENTO")
    private Long id;

    @Column(name = "NUMERO_AGD", unique = true, nullable = false, length = 30)
    private String numeroAgd;

    @Column(name = "CLIENTE", nullable = false, length = 100)
    private String cliente;

    @Column(name = "SERVICO", nullable = false, length = 100)
    private String servico;

    @Column(name = "DATA_HORA", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;
}

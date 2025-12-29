package com.agendify.agendamento.controller;

import com.agendify.agendamento.dto.AgendamentoInDTO;
import com.agendify.agendamento.dto.AgendamentoOutDTO;
import com.agendify.agendamento.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@Tag(name = "Agendamentos", description = "Endpoints de gerenciamento de agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lista todos os agendamentos")
    public ResponseEntity<List<AgendamentoOutDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Cria um novo agendamento")
    public ResponseEntity<AgendamentoOutDTO> criar(@RequestBody AgendamentoInDTO dto) {
        return ResponseEntity.ok(service.criarAgendamento(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um agendamento existente")
    public ResponseEntity<AgendamentoOutDTO> atualizar(@PathVariable Long id, @RequestBody AgendamentoInDTO dto) {
        return ResponseEntity.ok(service.atualizarAgendamento(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um agendamento")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}

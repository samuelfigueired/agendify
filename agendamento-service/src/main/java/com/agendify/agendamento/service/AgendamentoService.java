package com.agendify.agendamento.service;

import com.agendify.agendamento.dto.AgendamentoInDTO;
import com.agendify.agendamento.dto.AgendamentoOutDTO;
import com.agendify.agendamento.mapper.AgendamentoMapper;
import com.agendify.agendamento.entities.Agendamento;
import com.agendify.agendamento.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.UUID;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final AgendamentoMapper mapper;

    public AgendamentoService(AgendamentoRepository repository, AgendamentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AgendamentoOutDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toOutDTO)
                .toList();
    }

    public AgendamentoOutDTO criarAgendamento(AgendamentoInDTO dto) {
        Agendamento entity = mapper.toEntity(dto);

        String ano = String.valueOf(Year.now().getValue());
        String random = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        entity.setNumeroAgd(String.format("AGD-%s-%s", ano, random));

         if (entity.getStatus() == null || entity.getStatus().isBlank()) {
            entity.setStatus("PENDENTE");
        }

        return mapper.toOutDTO(repository.save(entity));
    }

    public AgendamentoOutDTO atualizarAgendamento(Long id, AgendamentoInDTO dto) {
        return repository.findById(id)
                .map(agendamento -> {
                    agendamento.setCliente(dto.getCliente());
                    agendamento.setServico(dto.getServico());
                    agendamento.setDataHora(dto.getDataHora());
                    agendamento.setStatus(dto.getStatus());
                    return mapper.toOutDTO(repository.save(agendamento));
                })
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado: " + id));
    }

    public void deletarAgendamento(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado: " + id);
        }
        repository.deleteById(id);
    }
}

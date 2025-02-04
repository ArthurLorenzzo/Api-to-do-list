package com.br.arthur.apitodolist.service;

import com.br.arthur.apitodolist.dto.AtualizarStatusDto;
import com.br.arthur.apitodolist.dto.TarefaDto;
import com.br.arthur.apitodolist.model.Tarefa;
import com.br.arthur.apitodolist.repository.TarefaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TarefaService {
    private static final Logger logger = LoggerFactory.getLogger(TarefaService.class);

    @Autowired
    private TarefaRepository repository;

    public TarefaDto create (TarefaDto tarefaDto) {
        logger.info("Criando Tarefa...");

        var tarefa = new Tarefa();
        BeanUtils.copyProperties(tarefaDto, tarefa);
        var createdTarefa = repository.save(tarefa);
        BeanUtils.copyProperties(createdTarefa, tarefaDto);

        logger.info("Tarefa criada, Id = " + tarefaDto.getId());

        return tarefaDto;
    }

    public TarefaDto findById (Long id) {
        logger.info("Buscando Tarefa com Id = " + id);
        var tarefaDTO = new TarefaDto();
        var tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        BeanUtils.copyProperties(tarefa, tarefaDTO);
        return tarefaDTO;
    }

    public List<TarefaDto> findAll() {
        logger.info("Buscando lista de tarefas...");
        List<Tarefa> tarefas = repository.findAll();

        return tarefas.stream()
                .map(tarefa -> {
                    var tarefaDto = new TarefaDto();
                    BeanUtils.copyProperties(tarefa, tarefaDto);
                    return tarefaDto;
                })
                .toList();
    }

    public TarefaDto updateStatus(Long id, AtualizarStatusDto statusDto) {
        logger.info("Atualizando status da tarefa de Id = " + id);
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setStatus(statusDto.getStatus());
        tarefa = repository.save(tarefa);
        return new TarefaDto(tarefa);
    }

    public void deleteById (Long id) {
        logger.info("Deletando tarefa de Id = " + id);
        repository.deleteById(id);
    }

}

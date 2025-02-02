package com.br.arthur.apitodolist.controller;

import com.br.arthur.apitodolist.dto.AtualizarStatusDto;
import com.br.arthur.apitodolist.dto.TarefaDto;
import com.br.arthur.apitodolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaDto> create (@RequestBody @Valid TarefaDto tarefaDto) {
        var tarefaCriada = service.create(tarefaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDto>> findList () {
        var listaDaTarefas = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaDaTarefas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TarefaDto> findById (@PathVariable Long id) {
        var tarefa = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(tarefa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateStatus (@PathVariable Long id, @Valid @RequestBody AtualizarStatusDto status) {
        service.updateStatus(id, status);
        return ResponseEntity.status(HttpStatus.OK).body("Status Atualizado com sucesso");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

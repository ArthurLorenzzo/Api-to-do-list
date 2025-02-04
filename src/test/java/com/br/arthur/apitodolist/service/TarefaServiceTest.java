package com.br.arthur.apitodolist.service;

import com.br.arthur.apitodolist.dto.AtualizarStatusDto;
import com.br.arthur.apitodolist.dto.TarefaDto;
import com.br.arthur.apitodolist.shared.enums.StatusEnum;
import com.br.arthur.apitodolist.model.Tarefa;
import com.br.arthur.apitodolist.repository.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    private Tarefa tarefa;
    private TarefaDto tarefaDto;

    private AtualizarStatusDto statusDto;

    @BeforeEach
    void setUp() {
        tarefa = new Tarefa(1L, "Estudar JUnit", "Aprender testes no Spring", StatusEnum.Pendente);
        tarefaDto = new TarefaDto(1L, "Estudar JUnit", "Aprender testes no Spring", StatusEnum.Pendente);
        statusDto = new AtualizarStatusDto(StatusEnum.Concluida);
    }

    @Test
    void shouldCreateTarefa() {
        when(tarefaRepository.save(any())).thenReturn(tarefa);

        TarefaDto resultado = tarefaService.create(tarefaDto);

        assertNotNull(resultado);
        assertEquals("Estudar JUnit", resultado.getTitulo());
        verify(tarefaRepository, times(1)).save(any());
    }

    @Test
    void shouldFindAllTarefas() {
        when(tarefaRepository.findAll()).thenReturn(List.of(tarefa));

        List<TarefaDto> resultado = tarefaService.findAll();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals("Estudar JUnit", resultado.get(0).getTitulo());
    }

    @Test
    void shouldFindByIdTarefa() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        TarefaDto resultado = tarefaService.findById(1L);

        assertNotNull(resultado);
        assertEquals("Estudar JUnit", resultado.getTitulo());
    }

    @Test
    void shoulUpdateStatusTarefa() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        when(tarefaRepository.save(any())).thenReturn(tarefa);

        tarefa.setStatus(StatusEnum.Concluida);
        TarefaDto resultado = tarefaService.updateStatus(1L, statusDto);

        assertEquals(StatusEnum.Concluida, resultado.getStatus());
    }

    @Test
    void shouldDeleteTarefa() {
        doNothing().when(tarefaRepository).deleteById(1L);

        tarefaService.deleteById(1L);

        verify(tarefaRepository, times(1)).deleteById(1L);
    }
}


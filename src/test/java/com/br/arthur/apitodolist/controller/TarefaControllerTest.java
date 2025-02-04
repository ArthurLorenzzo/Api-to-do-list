package com.br.arthur.apitodolist.controller;

import com.br.arthur.apitodolist.dto.TarefaDto;
import com.br.arthur.apitodolist.shared.enums.StatusEnum;
import com.br.arthur.apitodolist.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TarefaController.class)
class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TarefaService tarefaService;

    @InjectMocks
    private TarefaController tarefaController;

    private TarefaDto tarefaDto;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tarefaController).build();
        tarefaDto = new TarefaDto(1L, "Estudar JUnit", "Aprender testes no Spring", StatusEnum.Pendente);
    }

    @Test
    void shoulCreate() throws Exception {
        when(tarefaService.create(any())).thenReturn(tarefaDto);

        mockMvc.perform(post("/api/tarefas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"titulo\": \"Estudar JUnit\", \"descricao\": \"Aprender testes no Spring\", \"status\": \"Pendente\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldFindAll() throws Exception {
        when(tarefaService.findAll()).thenReturn(List.of(tarefaDto));

        mockMvc.perform(get("/api/tarefas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].titulo").value("Estudar JUnit"));
    }

    @Test
    void shouldFindById() throws Exception {
        when(tarefaService.findById(1L)).thenReturn(tarefaDto);

        mockMvc.perform(get("/api/tarefas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Estudar JUnit"));
    }

    @Test
    void shouldUpdateStatus() throws Exception {
        when(tarefaService.updateStatus(eq(1L), any())).thenReturn(tarefaDto);

        mockMvc.perform(put("/api/tarefas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\": \"Concluida\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDelete() throws Exception {
        doNothing().when(tarefaService).deleteById(1L);

        mockMvc.perform(delete("/api/tarefas/1"))
                .andExpect(status().isNoContent());
    }
}

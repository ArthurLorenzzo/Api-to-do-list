package com.br.arthur.apitodolist.repository;

import com.br.arthur.apitodolist.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

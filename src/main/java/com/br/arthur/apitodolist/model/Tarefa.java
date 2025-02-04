package com.br.arthur.apitodolist.model;

import com.br.arthur.apitodolist.shared.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String titulo;

    @Column
    private String descricao;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusEnum status;

    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, StatusEnum status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}

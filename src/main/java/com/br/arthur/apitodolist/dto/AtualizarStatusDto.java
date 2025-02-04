package com.br.arthur.apitodolist.dto;

import com.br.arthur.apitodolist.shared.enums.StatusEnum;
import jakarta.validation.constraints.NotNull;

public class AtualizarStatusDto {

    @NotNull(message = "O campo status é obrigatório")
    private StatusEnum status;

    public StatusEnum getStatus() {
        return status;
    }

    public AtualizarStatusDto() {
    }

    public AtualizarStatusDto(StatusEnum status) {
        this.status = status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}

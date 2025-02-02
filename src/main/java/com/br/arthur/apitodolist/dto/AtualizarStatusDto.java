package com.br.arthur.apitodolist.dto;

import com.br.arthur.apitodolist.enums.StatusEnum;
import jakarta.validation.constraints.NotNull;

public class AtualizarStatusDto {

    @NotNull(message = "O atributo status é obrigatório")
    private StatusEnum status;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}

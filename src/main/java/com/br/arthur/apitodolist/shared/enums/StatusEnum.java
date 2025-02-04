package com.br.arthur.apitodolist.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusEnum {
    Pendente,

    @JsonProperty("Em Andamento")
    Em_Andamento,
    Concluida
}

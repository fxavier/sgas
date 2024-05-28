package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Duration {
    CURTO_PRAZO("Curto Prazo"),
    MEDIO_PRAZO("Médio Prazo"),
    LONGO_PRAZO("Longo Prazo"),
    PERMANENTE("Permanente");

    private String description;

 

}
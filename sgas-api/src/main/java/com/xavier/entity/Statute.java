package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Statute {
    POSITIVO("Positivo"),
    NEGATIVO("Negativo");

    private String description;

}

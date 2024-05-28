package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Intensity {
    BAIXA("Baixa"),
    MEDIA("Média"),
    ALTA("Alta");

    private String description;

}

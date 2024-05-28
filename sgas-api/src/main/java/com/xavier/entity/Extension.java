package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Extension {
    REGIONAL("Regional"),
    NA_AREA_ENVOLVENTE("Na Área Envolvente"),
    LOCAL("Local");

    private String description;

  
}

package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Probability {
    IMPROVAVEL("Improvável"),
    PROVAVEL("Provável"),
    ALTAMENTE_PROVAVEL("Altamente Provável"),
    DEFINITIVA("Definitiva");

    private String description;

   
}

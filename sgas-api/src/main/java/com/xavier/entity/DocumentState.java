package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentState {
    REVISION("Revisão"),
    INUSE("Em uso"),
    ABSOLETE("Obsoleto");

    private String description;
    
}

package com.xavier.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LifeCycle {
    
    PRE_CONSTRUCAO("Pré-Construção"),
    CONSTRUCAO("Construção"),
    OPERACAO("Operação"),
    DESATIVACAO("Desativação"),
    ENCERRAMENTO("Encerramento"),
    REINTEGRACAO_RESTAURACAO("Reintegração/Restauração");

    private String description;



}

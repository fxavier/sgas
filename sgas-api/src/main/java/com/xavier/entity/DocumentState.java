package com.xavier.entity;

public enum DocumentState {
    REVISION("Revisão"),
    INUSE("Em uso"),
    ABSOLETE("Obsoleto");

    private String description;

    DocumentState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package com.xavier.repository;

import com.xavier.entity.DocumentType;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DocumentTypeRepository implements PanacheRepository<DocumentType> {
    
}

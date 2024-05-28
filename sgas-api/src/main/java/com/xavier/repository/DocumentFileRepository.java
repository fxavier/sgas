package com.xavier.repository;

import com.xavier.entity.DocumentFile;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DocumentFileRepository implements PanacheRepository<DocumentFile>{
    
}

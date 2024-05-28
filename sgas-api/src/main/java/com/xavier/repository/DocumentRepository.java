package com.xavier.repository;

import com.xavier.entity.Document;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DocumentRepository implements PanacheRepository<Document> {

    public Document findByDocumentName(String documentName) {
        return find("documentName", documentName).firstResult();
    }
    
}

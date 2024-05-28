package com.xavier.service;

import java.util.ArrayList;
import java.util.List;

import com.xavier.dto.DocumentDTO;
import com.xavier.entity.Document;
import com.xavier.repository.DocumentRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DocumentServiceImpl implements DocumentService {

    @Inject
    DocumentRepository documentRepository;



    @Transactional
    @Override
    public DocumentDTO create(DocumentDTO documentDTO) {
         if (documentExists(documentDTO.getDocumentName())) {
              throw new IllegalArgumentException("Document already exists: " + documentDTO.getDocumentName());
         }
       DocumentDTO document = createDocument(documentDTO);
       return document;
    }

    
    @Transactional
    @Override
    public DocumentDTO update(DocumentDTO documentDTO) {
       if (documentDTO.getId() == null) {
           throw new IllegalArgumentException("Document ID must not be null for update");
       }

       Document document = documentRepository.findById(documentDTO.getId());
       if (document == null) {
           throw new IllegalStateException("No document found with ID " + documentDTO.getId());
       }

        document.setCode(documentDTO.getCode());
        document.setDocumentName(documentDTO.getDocumentName());
        document.setDocumentType(documentDTO.getDocumentType());
        document.setCreationDate(documentDTO.getCreationDate());
        document.setDocumentState(documentDTO.getDocumentState());
        document.setDocumentPath(documentDTO.getDocumentPath());
        document.setDisposalMethod(documentDTO.getDisposalMethod());
        document.setRevisionDate(documentDTO.getRevisionDate());
        document.setRetentionPeriod(documentDTO.getRetentionPeriod());
        document.setObservation(documentDTO.getObservation());

        documentRepository.persist(document); // Optional based on JPA provider if using managed entity

        return DocumentDTO.builder()
            .id(document.getId())
            .code(document.getCode())
            .documentName(document.getDocumentName())
            .documentType(document.getDocumentType())
            .creationDate(document.getCreationDate())
            .documentState(document.getDocumentState())
            .documentPath(document.getDocumentPath())
            .disposalMethod(document.getDisposalMethod())
            .revisionDate(document.getRevisionDate())
            .retentionPeriod(document.getRetentionPeriod())
            .observation(document.getObservation())
            .build();
    }
    
    @Override
    public DocumentDTO findById(Long id) {
       Document document = documentRepository.findById(id);
         return DocumentDTO.builder()
              .id(document.getId())
              .code(document.getCode())
              .documentName(document.getDocumentName())
              .documentType(document.getDocumentType())
              .creationDate(document.getCreationDate())
              .documentState(document.getDocumentState())
              .documentPath(document.getDocumentPath())
              .disposalMethod(document.getDisposalMethod())
              .revisionDate(document.getRevisionDate())
              .retentionPeriod(document.getRetentionPeriod())
              .observation(document.getObservation())
              .build();
    }
    
    @Override
    public DocumentDTO findByName(String name) {
        Document document = documentRepository.findByDocumentName(name);
        return DocumentDTO.builder()
            .id(document.getId())
            .code(document.getCode())
            .documentName(document.getDocumentName())
            .documentType(document.getDocumentType())
            .creationDate(document.getCreationDate())
            .documentState(document.getDocumentState())
            .documentPath(document.getDocumentPath())
            .disposalMethod(document.getDisposalMethod())
            .revisionDate(document.getRevisionDate())
            .retentionPeriod(document.getRetentionPeriod())
            .observation(document.getObservation())
            .build();
    }
    
    @Override
    public List<DocumentDTO> findAll() {
        List<DocumentDTO> documents = new ArrayList<>();

        documentRepository
            .findAll()
            .stream()
            .forEach(item -> {
                 documents.add(DocumentDTO.builder()
                    .id(item.getId())
                    .code(item.getCode())
                    .documentName(item.getDocumentName())
                    .documentType(item.getDocumentType())
                    .creationDate(item.getCreationDate())
                    .documentState(item.getDocumentState())
                    .documentPath(item.getDocumentPath())
                    .disposalMethod(item.getDisposalMethod())
                    .revisionDate(item.getRevisionDate())
                    .retentionPeriod(item.getRetentionPeriod())
                    .observation(item.getObservation())
                    .build());
            });

            return documents;
    }
    
    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }

    @Transactional
    DocumentDTO createDocument(DocumentDTO documentDTO) {
       try {
        Document document = new Document();
        document.setCode(documentDTO.getCode());
        document.setDocumentName(documentDTO.getDocumentName());
        document.setDocumentType(documentDTO.getDocumentType());
        document.setCreationDate(documentDTO.getCreationDate());
        document.setDocumentState(documentDTO.getDocumentState());
        document.setDocumentPath(documentDTO.getDocumentPath());
        document.setDisposalMethod(documentDTO.getDisposalMethod());
        document.setRevisionDate(documentDTO.getRevisionDate());
        document.setRetentionPeriod(documentDTO.getRetentionPeriod());
        document.setObservation(documentDTO.getObservation());

        documentRepository.persist(document);

        return DocumentDTO.builder()
            .id(document.getId())
            .code(document.getCode())
            .documentName(document.getDocumentName())
            .documentType(document.getDocumentType())
            .creationDate(document.getCreationDate())
            .documentState(document.getDocumentState())
            .documentPath(document.getDocumentPath())
            .disposalMethod(document.getDisposalMethod())
            .revisionDate(document.getRevisionDate())
            .retentionPeriod(document.getRetentionPeriod())
            .observation(document.getObservation())
            .build();

        
       } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error creating document");
       }
    }

    private boolean documentExists(String documentName) {
        Document document = documentRepository.findByDocumentName(documentName);
        return document != null;
    }
    
}

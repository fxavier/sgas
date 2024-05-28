package com.xavier.service;

import java.util.ArrayList;
import java.util.List;

import com.xavier.dto.DocumentTypeDTO;
import com.xavier.entity.DocumentType;
import com.xavier.repository.DocumentTypeRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DocumentTypeServiceImpl implements DocumentTypeService{

    @Inject
    DocumentTypeRepository documentTypeRepository;

    @Override
    @Transactional
    public DocumentTypeDTO create(DocumentTypeDTO documentTypeDTO) {
        DocumentTypeDTO documentType = createDocumentType(documentTypeDTO);
        return documentType;
    }

    @Override
    @Transactional
    public DocumentTypeDTO update(DocumentTypeDTO documentTypeDTO) {
        if (documentTypeDTO.getId() == null) {
            throw new IllegalArgumentException("Document type ID must not be null for update");
        }

        DocumentType documentType = documentTypeRepository.findById(documentTypeDTO.getId());
        if (documentType == null) {
            throw new IllegalStateException("No document type found with ID " + documentTypeDTO.getId());
        }

        documentType.setName(documentTypeDTO.getName());
        documentType.setDescription(documentTypeDTO.getDescription());
        documentTypeRepository.persist(documentType); // Optional based on JPA provider if using managed entity

        return DocumentTypeDTO.builder()
            .id(documentType.getId())
            .name(documentType.getName())
            .description(documentType.getDescription())
            .build();
    }


    @Override
    public DocumentTypeDTO findById(Long id) {
        DocumentType documentType = documentTypeRepository.findById(id);
        return DocumentTypeDTO.builder()
            .id(documentType.getId())
            .name(documentType.getName())
            .description(documentType.getDescription())
            .build();
    }

    @Override
    public List<DocumentTypeDTO> findAll() {
       List<DocumentTypeDTO> documentTypes = new ArrayList<>();

         documentTypeRepository
                   .findAll()
                   .stream()
                   .forEach(item -> {
                     documentTypes.add(DocumentTypeDTO.builder()
                       .id(item.getId())
                       .name(item.getName())
                       .description(item.getDescription())
                       .build());
                   });

                   return documentTypes;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        documentTypeRepository.deleteById(id);
    }

    @Transactional
    DocumentTypeDTO createDocumentType(DocumentTypeDTO documentTypeDTO) {
        try {
            DocumentType documentType = new DocumentType();

            documentType.setName(documentTypeDTO.getName());
            documentType.setDescription(documentTypeDTO.getDescription());
            
            documentTypeRepository.persist(documentType);

            return DocumentTypeDTO.builder()
                .id(documentType.getId())
                .name(documentType.getName())
                .description(documentType.getDescription())
                .build();
        } catch (Exception e) {
       
            e.printStackTrace();
            throw new RuntimeException("Error creating document type");
        }
    }

    
}
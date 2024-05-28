package com.xavier.service;

import java.util.List;

import com.xavier.dto.DocumentTypeDTO;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public interface DocumentTypeService {

    DocumentTypeDTO create(DocumentTypeDTO documentTypeDTO);

    DocumentTypeDTO update(DocumentTypeDTO documentTypeDTO);

    DocumentTypeDTO findById(Long id);

    List<DocumentTypeDTO> findAll();

    void delete(Long id);

} 

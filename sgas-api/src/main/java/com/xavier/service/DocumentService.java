package com.xavier.service;

import java.util.List;

import com.xavier.dto.DocumentDTO;

public interface DocumentService {

    DocumentDTO create(DocumentDTO documentDTO);

    DocumentDTO update(DocumentDTO documentDTO);

    DocumentDTO findById(Long id);

    DocumentDTO findByName(String name);

    List<DocumentDTO> findAll();

    void delete(Long id);
}

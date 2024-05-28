package com.xavier.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.xavier.dto.DocumentFileDTO;
import com.xavier.entity.DocumentFile;
import com.xavier.repository.DocumentFileRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FileUploadService {

    @Inject
    private DocumentFileRepository documentFileRepository;

    public DocumentFileDTO storeFile(InputStream filStream, String fileName, String contentType) throws Exception {
        Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        Path filePath = uploadDir.resolve(fileName);
        Files.copy(filStream, filePath);
        
        DocumentFile documentFile = new DocumentFile();

       // return new DocumentFileDTO(fileName, contentType);

       return null;
    }
    
}

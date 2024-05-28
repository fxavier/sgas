package com.xavier.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.xavier.dto.DocumentDTO;
import com.xavier.entity.Document;
import com.xavier.entity.DocumentFile;
import com.xavier.repository.DocumentFileRepository;
import com.xavier.service.DocumentService;
import com.xavier.storage.local.FileUploadForm;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/upload")
public class FileUploadResource {
    
    @Inject
    DocumentFileRepository fileRepository;

    @Inject
    DocumentService documentService;

    private static final String UPLOAD_DIR = "file_upload";

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response uploadFile(@MultipartForm FileUploadForm form) {
        try {
            // Ensure directory exists
            java.nio.file.Path uploadDir = java.nio.file.Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            // Save the file locally
             // Sanitize and ensure filename length is acceptable
            String originalFileName = form.fileName;
            String sanitizedFileName = sanitizeFileName(originalFileName);
            String fileExtension = getFileExtension(sanitizedFileName);
            String baseFileName = getBaseFileName(sanitizedFileName);

            // Ensure filename length does not exceed the limit
            String uniqueFileName = baseFileName;
            if (uniqueFileName.length() > 100) {
                uniqueFileName = uniqueFileName.substring(0, 100);
            }
            uniqueFileName += "_" + UUID.randomUUID().toString() + fileExtension;

            // Save the file locally
            java.nio.file.Path filePath = uploadDir.resolve(uniqueFileName);
            Files.copy(form.fileData, filePath, StandardCopyOption.REPLACE_EXISTING);

            DocumentDTO documentDTO = documentService.findById(1L);
            Document document = Document.builder()
                    .id(documentDTO.getId())
                    .code(documentDTO.getCode())
                    .documentName(documentDTO.getDocumentName())
                    .documentType(documentDTO.getDocumentType())
                    .creationDate(documentDTO.getCreationDate())
                    .documentState(documentDTO.getDocumentState())
                    .documentPath(String.valueOf(filePath))
                    .disposalMethod(documentDTO.getDisposalMethod())
                    .revisionDate(documentDTO.getRevisionDate())
                    .retentionPeriod(documentDTO.getRetentionPeriod())
                    .observation(documentDTO.getObservation())
                    .build();
            
           // Update this to associate with a specific Document if necessary
            // Create and save DocumentFile entity
            DocumentFile documentFile = DocumentFile.builder()
                    .document(document) // Update this to associate with a specific Document if necessary
                    .documentPath(String.valueOf(filePath))
                    .contentType(form.fileType)
                    .build();
            fileRepository.persist(documentFile);

            return Response.ok("File uploaded successfully").build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("File upload failed").build();
        }
    }

    private String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
    }

    private String getFileExtension(String fileName) {
        int lastIndexOfDot = fileName.lastIndexOf('.');
        return (lastIndexOfDot == -1) ? "" : fileName.substring(lastIndexOfDot);
    }

    private String getBaseFileName(String fileName) {
        int lastIndexOfDot = fileName.lastIndexOf('.');
        return (lastIndexOfDot == -1) ? fileName : fileName.substring(0, lastIndexOfDot);
    }
}

package com.xavier.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.xavier.entity.DocumentState;
import com.xavier.entity.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDTO {
    private Long id;
    private String code;
    private LocalDateTime creationDate;
    private LocalDateTime revisionDate;
    private String documentName;
    private DocumentType documentType;
    private String documentPath;
    private DocumentState documentState;
    private LocalDate retentionPeriod;
    private String disposalMethod;
    private String observation;
}

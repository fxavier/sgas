package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentFileDTO {
    
    private Long id;
    private DocumentDTO document;
    private String documentPath;
    private String contentType;
}

package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RisksAndImpactsDTO {

    private Long id;
    private String description;
    
}

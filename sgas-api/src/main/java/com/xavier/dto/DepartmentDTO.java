package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DepartmentDTO {

    private Long id;
    private String name;
    private String description;
    
}

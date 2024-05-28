package com.xavier.dto;

import java.time.LocalDateTime;

import com.xavier.entity.Department;
import com.xavier.entity.Duration;
import com.xavier.entity.EnvironmentalFactor;
import com.xavier.entity.Extension;
import com.xavier.entity.Intensity;
import com.xavier.entity.LifeCycle;
import com.xavier.entity.Probability;
import com.xavier.entity.RisksAndImpact;
import com.xavier.entity.Statute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AriasDTO {
private Long id;
    private Department departament;
    private String activity;
    private RisksAndImpact risksAndImpact;
    private EnvironmentalFactor environmentalFactor;
    private LifeCycle lifeCycle;
    private Statute statute;
    private Extension extension;
    private Duration duration;
    private Intensity intensity;
    private Probability probability;
    private String meaningfulness;
    private String descriptionOfMesures;
    private String deadline;
    private String effectivenessAssessment;
    private String observations;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}

package com.xavier.entity;

import java.time.LocalDateTime;

import com.aayushatharva.brotli4j.common.annotations.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "arias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Arias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Department departament;
    @Column(name = "actividade")
    private String activity;
    @ManyToOne
    @JoinColumn(name = "riscos_e_impactos_id")
    private RisksAndImpact risksAndImpact;
    @ManyToOne
    @JoinColumn(name = "factor_ambiental_id")   
    private EnvironmentalFactor environmentalFactor;
    @Enumerated(EnumType.STRING)
    @Column(name = "ciclo_de_vida")
    private LifeCycle lifeCycle;
    @Enumerated(EnumType.STRING)
    @Column(name = "estatuto")
    private Statute statute;
    @Enumerated(EnumType.STRING)
    @Column(name = "extensao")
    private Extension extension;
    @Enumerated(EnumType.STRING)
    @Column(name = "duracao")
    private Duration duration;
    @Enumerated(EnumType.STRING)
    @Column(name = "intensidade")
    private Intensity intensity;
    @Enumerated(EnumType.STRING)
    @Column(name = "probabilidade")
    private Probability probability;
    @Column(name = "significancia")
    private String meaningfulness;
    @Column(name = "descricao_das_medidas")
    private String descriptionOfMesures; 
    //private User responsable;  
    @Column(name = "prazo")
    private String deadline;
    @Column(name = "avaliacao_da_eficacia")
    private String effectivenessAssessment;
    @Column(name = "observacoes")
    private String observations;
    @Column(name = "data_criacao")
    private LocalDateTime createdAt;
    @Column(name = "data_actualizacao")
    private LocalDateTime updatedAt;


}

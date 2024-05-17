package com.xavier.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "documentos")
@Setter
@Getter
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "codigo")
    private String code;
    @Column(name = "data_criacao")
    private LocalDateTime creationDate;
    @Column(name = "data_revisao")
    private LocalDateTime revisionDate;
    @Column(name = "nome_documento")
    private String documentName;
    @ManyToOne
    @JoinColumn(name = "tipo_documento")
    private DocumentType documentType;
    @Column(name = "local_arquivo")
    private String documentPath;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private DocumentState documentState;
    @Column(name = "perido_retencao")
    private LocalDate retentionPeriod;
    @Column(name = "forma_eliminacao")
    private String disposalMethod;
    @Column(name = "url")
    private String url;
    @Column(name = "observacao")
    private String observation;

}

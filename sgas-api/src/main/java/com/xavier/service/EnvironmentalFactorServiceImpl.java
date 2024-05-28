package com.xavier.service;

import java.util.List;
import java.util.Optional;

import com.xavier.dto.EnvironmentalFactorDTO;
import com.xavier.entity.EnvironmentalFactor;
import com.xavier.repository.EnvironmentalFactorRepository;
import com.xavier.service.exception.DepartmentException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EnvironmentalFactorServiceImpl implements EnvironmentalFactorService{

    @Inject
    EnvironmentalFactorRepository environmentalFactorRepository;

    
    @Override
    @Transactional
    public EnvironmentalFactorDTO create(EnvironmentalFactorDTO environmentalFactorDTO) {
        EnvironmentalFactor environmentFactor = toEntity(environmentalFactorDTO);
        environmentalFactorRepository.persist(environmentFactor);
        return environmentalFactorDTO;
    }

    @Override
    public EnvironmentalFactorDTO findById(Long id) {
        Optional<EnvironmentalFactor> environmentalFactor = environmentalFactorRepository.findByIdOptional(id);
        if (!environmentalFactor.isPresent()) {
            throw new DepartmentException("Environmental Factor not found");
        }
        return toDTO(environmentalFactor.get());
    }

    @Override
    @Transactional
    public EnvironmentalFactorDTO update(Long id, EnvironmentalFactorDTO environmentalFactorDTO) {
        Optional<EnvironmentalFactor> environmentalFactor = environmentalFactorRepository.findByIdOptional(id);
        if (!environmentalFactor.isPresent()) {
            throw new DepartmentException("Environmental Factor not found");
        }
        return toDTO(environmentalFactor.get());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<EnvironmentalFactor> environmentalFactor = environmentalFactorRepository.findByIdOptional(id);
        if (!environmentalFactor.isPresent()) {
            throw new DepartmentException("Environmental Factor not found");
        }
        environmentalFactorRepository.delete(environmentalFactor.get());
    }

    @Override
    public List<EnvironmentalFactorDTO> findAll() {
        return environmentalFactorRepository
                .listAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private EnvironmentalFactorDTO toDTO(EnvironmentalFactor environmentalFactor) {
        return EnvironmentalFactorDTO.builder()
                .id(environmentalFactor.getId())
                .description(environmentalFactor.getDescription())
                .build();
    }

    private EnvironmentalFactor toEntity(EnvironmentalFactorDTO environmentalFactorDTO) {
        return EnvironmentalFactor.builder()
                .id(environmentalFactorDTO.getId())
                .description(environmentalFactorDTO.getDescription())
                .build();
    }
    
}

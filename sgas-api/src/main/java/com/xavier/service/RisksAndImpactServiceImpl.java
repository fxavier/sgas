package com.xavier.service;

import java.util.List;
import java.util.Optional;

import com.xavier.dto.RisksAndImpactsDTO;
import com.xavier.entity.RisksAndImpact;
import com.xavier.repository.RisksAndImpactRepository;
import com.xavier.service.exception.DepartmentException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RisksAndImpactServiceImpl implements RisksAndImpactService{

    @Inject
    RisksAndImpactRepository risksAndImpactRepository;

    @Override
    @Transactional
    public RisksAndImpactsDTO create(RisksAndImpactsDTO risksAndImpactsDTO) {
       if (existsRisksAndImpact(risksAndImpactsDTO.getDescription())) {
           throw new DepartmentException("Risks and Impact already exists: " + risksAndImpactsDTO.getDescription());
       }
        RisksAndImpact risksAndImpact = toEntity(risksAndImpactsDTO);
        risksAndImpactRepository.persist(risksAndImpact);
        return toDTO(risksAndImpact);

    }

    @Override
    @Transactional
    public RisksAndImpactsDTO update(Long id, RisksAndImpactsDTO risksAndImpactsDTO) {
         Optional<RisksAndImpact> risksAndImpactOptional = risksAndImpactRepository.findByIdOptional(id);
            if(!risksAndImpactOptional.isPresent()) {
                throw new DepartmentException("Risks and Impact not found");
            }
            RisksAndImpact risksAndImpact = risksAndImpactOptional.get();
            risksAndImpact.setDescription(risksAndImpactsDTO.getDescription());
            risksAndImpactRepository.persist(risksAndImpact);
            return toDTO(risksAndImpact);
    }

    @Override
    public RisksAndImpactsDTO findById(Long id) {
        Optional<RisksAndImpact> risksAndImpactOptional = risksAndImpactRepository.findByIdOptional(id);
        if(!risksAndImpactOptional.isPresent()) {
            throw new DepartmentException("Risks and Impact not found");
        }
        RisksAndImpact risksAndImpact = risksAndImpactOptional.get();
        return toDTO(risksAndImpact);
    }

    @Override
    public List<RisksAndImpactsDTO> findAll() {
        return risksAndImpactRepository
               .listAll()
               .stream()
               .map(this::toDTO)
               .toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<RisksAndImpact> risksAndImpactOptional = risksAndImpactRepository.findByIdOptional(id);
        if(!risksAndImpactOptional.isPresent()) {
            throw new DepartmentException("Risks and Impact not found");
        }
        RisksAndImpact risksAndImpact = risksAndImpactOptional.get();
        risksAndImpactRepository.delete(risksAndImpact);
    }

    private RisksAndImpactsDTO toDTO(RisksAndImpact risksAndImpact) {
       return RisksAndImpactsDTO.builder()
               .id(risksAndImpact.getId())
               .description(risksAndImpact.getDescription())
               .build();
    }

    private RisksAndImpact toEntity(RisksAndImpactsDTO risksAndImpactsDTO) {
        return RisksAndImpact.builder()
                .id(risksAndImpactsDTO.getId())
                .description(risksAndImpactsDTO.getDescription())
                .build();
    }

    private boolean existsRisksAndImpact(String description) {
        return risksAndImpactRepository.findByDescription(description) != null;
    }
    
}

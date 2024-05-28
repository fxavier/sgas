package com.xavier.service;

import java.util.List;
import java.util.Optional;

import com.xavier.dto.AriasDTO;
import com.xavier.entity.Arias;
import com.xavier.repository.AriasRepository;
import com.xavier.service.exception.AriasException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AriasServiceImpl implements AriasService{

    @Inject
    AriasRepository ariasRepository;

    @Override
    @Transactional
    public AriasDTO create(AriasDTO ariasDTO) {
        Arias arias = toEntity(ariasDTO);
        ariasRepository.persist(arias);
        return toDTO(arias);
    }

    @Override
    @Transactional
    public AriasDTO update(Long id, AriasDTO ariasDTO) {
       Optional<Arias> ariasOptional = ariasRepository.findByIdOptional(id);
         if (!ariasOptional.isPresent()) {
            throw new AriasException("Arias not found");
         }
        Arias arias = ariasOptional.get();
        arias.setDepartament(ariasDTO.getDepartament());
        arias.setActivity(ariasDTO.getActivity());
        arias.setRisksAndImpact(ariasDTO.getRisksAndImpact());
        arias.setEnvironmentalFactor(ariasDTO.getEnvironmentalFactor());
        arias.setLifeCycle(ariasDTO.getLifeCycle());
        arias.setStatute(ariasDTO.getStatute());
        arias.setExtension(ariasDTO.getExtension());
        arias.setDuration(ariasDTO.getDuration());
        arias.setIntensity(ariasDTO.getIntensity());
        arias.setProbability(ariasDTO.getProbability());
        arias.setMeaningfulness(ariasDTO.getMeaningfulness());
        arias.setDescriptionOfMesures(ariasDTO.getDescriptionOfMesures());
        arias.setDeadline(ariasDTO.getDeadline());
        arias.setEffectivenessAssessment(ariasDTO.getEffectivenessAssessment());
        arias.setObservations(ariasDTO.getObservations());
        ariasRepository.persist(arias);
        return toDTO(arias);
    }

    @Override
    public List<AriasDTO> findAll() {
       List<Arias> arias = ariasRepository.listAll();
         return arias
                    .stream()
                    .map(this::toDTO)
                    .toList();
    }

    @Override
    @Transactional
    public AriasDTO findById(Long id) {
        Optional<Arias> ariasOptional = ariasRepository.findByIdOptional(id);
        if (!ariasOptional.isPresent()) {
            throw new AriasException("Arias not found");
        }
        return toDTO(ariasOptional.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Arias> ariasOptional = ariasRepository.findByIdOptional(id);
        ariasOptional.ifPresent(ariasRepository::delete);
    }

    private AriasDTO toDTO(Arias arias) {
       return AriasDTO
                    .builder()
                    .id(arias.getId())
                    .departament(arias.getDepartament())
                    .activity(arias.getActivity())
                    .risksAndImpact(arias.getRisksAndImpact())
                    .environmentalFactor(arias.getEnvironmentalFactor())
                    .lifeCycle(arias.getLifeCycle())
                    .statute(arias.getStatute())
                    .extension(arias.getExtension())
                    .duration(arias.getDuration())
                    .intensity(arias.getIntensity())
                    .probability(arias.getProbability())
                    .meaningfulness(arias.getMeaningfulness())
                    .descriptionOfMesures(arias.getDescriptionOfMesures())
                    .deadline(arias.getDeadline())
                    .effectivenessAssessment(arias.getEffectivenessAssessment())
                    .observations(arias.getObservations())
                    .createdAt(arias.getCreatedAt())
                    .updatedAt(arias.getUpdatedAt())
                    .build();
    }

    private Arias toEntity(AriasDTO ariasDTO) {
        return Arias
                    .builder()
                    .id(ariasDTO.getId())
                    .departament(ariasDTO.getDepartament())
                    .activity(ariasDTO.getActivity())
                    .risksAndImpact(ariasDTO.getRisksAndImpact())
                    .environmentalFactor(ariasDTO.getEnvironmentalFactor())
                    .lifeCycle(ariasDTO.getLifeCycle())
                    .statute(ariasDTO.getStatute())
                    .extension(ariasDTO.getExtension())
                    .duration(ariasDTO.getDuration())
                    .intensity(ariasDTO.getIntensity())
                    .probability(ariasDTO.getProbability())
                    .meaningfulness(ariasDTO.getMeaningfulness())
                    .descriptionOfMesures(ariasDTO.getDescriptionOfMesures())
                    .deadline(ariasDTO.getDeadline())
                    .effectivenessAssessment(ariasDTO.getEffectivenessAssessment())
                    .observations(ariasDTO.getObservations())
                    .createdAt(ariasDTO.getCreatedAt())
                    .updatedAt(ariasDTO.getUpdatedAt())
                    .build();
    }
    
}

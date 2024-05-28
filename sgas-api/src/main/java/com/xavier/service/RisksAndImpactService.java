package com.xavier.service;

import java.util.List;

import com.xavier.dto.RisksAndImpactsDTO;

public interface RisksAndImpactService {
    
    RisksAndImpactsDTO create(RisksAndImpactsDTO risksAndImpactsDTO);
    RisksAndImpactsDTO update(Long id, RisksAndImpactsDTO risksAndImpactsDTO);
    RisksAndImpactsDTO findById(Long id);
    List<RisksAndImpactsDTO> findAll();
    void delete(Long id);
}

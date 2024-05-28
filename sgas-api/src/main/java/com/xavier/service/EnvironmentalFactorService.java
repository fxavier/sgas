package com.xavier.service;

import java.util.List;

import com.xavier.dto.EnvironmentalFactorDTO;

public interface EnvironmentalFactorService {
    
    EnvironmentalFactorDTO create(EnvironmentalFactorDTO environmentalFactor);

    EnvironmentalFactorDTO findById(Long id);

    EnvironmentalFactorDTO update(Long id, EnvironmentalFactorDTO environmentalFactor);

    void delete(Long id);

    List<EnvironmentalFactorDTO> findAll();
}

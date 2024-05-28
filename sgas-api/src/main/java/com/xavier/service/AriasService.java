package com.xavier.service;


import java.util.List;

import com.xavier.dto.AriasDTO;

public interface AriasService {
    
    AriasDTO create(AriasDTO ariasDTO);
    AriasDTO update(Long id, AriasDTO ariasDTO);
    List<AriasDTO> findAll();
    AriasDTO findById(Long id);
    void delete(Long id);
}

package com.xavier.service;


import java.util.List;

import com.xavier.dto.DepartmentDTO;

public interface DepartmentService {
    
    DepartmentDTO create(DepartmentDTO departmentDTO);

    DepartmentDTO update(Long id, DepartmentDTO departmentDTO);

    void delete(Long id);

    DepartmentDTO findById(Long id);

    List<DepartmentDTO> findAll();

}

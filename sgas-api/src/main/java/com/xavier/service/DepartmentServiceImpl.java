package com.xavier.service;

import java.util.List;
import java.util.Optional;

import com.xavier.dto.DepartmentDTO;
import com.xavier.entity.Department;
import com.xavier.repository.DepartmentRepository;
import com.xavier.service.exception.DepartmentException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DepartmentServiceImpl implements DepartmentService{

    @Inject
    DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public DepartmentDTO create(DepartmentDTO departmentDTO) {
        if (existsDepartment(departmentDTO.getName())) {
            throw new DepartmentException("Department already exists: " + departmentDTO.getName());
        }
       Department department = toEntity(departmentDTO);
       departmentRepository.persist(department);
       return toDTO(department);

    }

    @Override
    @Transactional
    public DepartmentDTO update(Long id, DepartmentDTO departmentDTO) {
       Optional<Department> departmentOptional = departmentRepository.findByIdOptional(id);
         if(!departmentOptional.isPresent()) {
             throw new RuntimeException("Department not found");
         } 
         Department department = departmentOptional.get();
         department.setName(departmentDTO.getName());
         department.setDescription(departmentDTO.getDescription());         
         departmentRepository.persist(department);
         return toDTO(department);
   
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Department> departmentOptional = departmentRepository.findByIdOptional(id);
        if(!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        } 
        Department department = departmentOptional.get();
        departmentRepository.delete(department);
    }

    @Override
    public DepartmentDTO findById(Long id) {
        Optional<Department> departmentOptional = departmentRepository.findByIdOptional(id);
        if(!departmentOptional.isPresent()) {
            throw new DepartmentException("Department not found");
        } 
        Department department = departmentOptional.get();
        return toDTO(department);
    }

    @Override
    public List<DepartmentDTO> findAll() {
        return departmentRepository.listAll()
               .stream()
               .map(this::toDTO)
               .toList();
    }

    private DepartmentDTO toDTO(Department department) {
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .build();
    }

    private Department toEntity(DepartmentDTO departmentDTO) {
        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .description(departmentDTO.getDescription())
                .build();
    }

    private boolean existsDepartment(String name) {
        return departmentRepository.findByName(name) != null;
    }
    
}

package com.xavier.repository;

import com.xavier.entity.RisksAndImpact;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RisksAndImpactRepository implements PanacheRepository<RisksAndImpact> {
 
    public RisksAndImpact findByDescription(String description) {
        return find("description", description).firstResult();
    }
    
}

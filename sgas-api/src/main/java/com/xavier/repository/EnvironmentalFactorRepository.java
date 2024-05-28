package com.xavier.repository;

import com.xavier.entity.EnvironmentalFactor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnvironmentalFactorRepository implements PanacheRepository<EnvironmentalFactor> {
    
}

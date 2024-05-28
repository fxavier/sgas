package com.xavier.repository;

import com.xavier.entity.Arias;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AriasRepository implements PanacheRepository<Arias> {
    
}

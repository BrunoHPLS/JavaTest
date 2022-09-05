package com.sigabem.fretecargas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigabem.fretecargas.model.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete,Long>{
    
}

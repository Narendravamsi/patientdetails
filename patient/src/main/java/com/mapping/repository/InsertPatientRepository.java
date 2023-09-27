package com.mapping.repository;

import com.mapping.entity.InsertPatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsertPatientRepository extends JpaRepository<InsertPatientEntity,Integer> {
}

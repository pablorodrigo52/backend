package com.aju.fit.ajufit.repository;

import com.aju.fit.ajufit.repository.model.ExecutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionRepository extends JpaRepository<ExecutionEntity, Long> {}

package com.aju.fit.ajufit.repository;

import com.aju.fit.ajufit.repository.model.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {}

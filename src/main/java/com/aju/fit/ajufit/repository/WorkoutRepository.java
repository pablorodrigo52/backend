package com.aju.fit.ajufit.repository;

import com.aju.fit.ajufit.repository.model.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {}

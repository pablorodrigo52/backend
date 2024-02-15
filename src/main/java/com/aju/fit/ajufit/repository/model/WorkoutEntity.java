package com.aju.fit.ajufit.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "workout")
public class WorkoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @Column(name = "date_last_updated")
    private LocalDateTime dateLastUpdated;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @OneToMany(mappedBy = "workout")
    private Set<ExerciseEntity> exercises;
    @OneToMany(mappedBy = "workout")
    private Set<ExecutionEntity> executions;
}

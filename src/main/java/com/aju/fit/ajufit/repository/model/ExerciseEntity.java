package com.aju.fit.ajufit.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "exercise")
public class ExerciseEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @Column(name = "date_last_updated")
    private LocalDateTime dateLastUpdated;
    @Column(name = "title")
    private String title;
    @Column(name = "serie_exercise")
    private Long serie;
    @Column(name = "repetition_exercise")
    private Long repetition;
    @Column(name = "load_exercise")
    private Long load;
    @Column(name = "interval_exercise")
    private Long interval;
    @Column(name = "media")
    private String media;
    @Column(name = "compound_bi_set_id")
    private Long compoundBiSetId;
    @Column(name = "compound_tri_set_id")
    private Long compoundTriSetId;
    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private WorkoutEntity workout;
    @OneToMany(mappedBy = "exercise")
    private Set<ExecutionEntity> executions;
}

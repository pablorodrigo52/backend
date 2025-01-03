package com.aju.fit.ajufit.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "execution")
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_started")
  private LocalDateTime dateStarted;

  @Column(name = "date_finished")
  private LocalDateTime dateFinished;

  @Column(name = "serie_executed")
  private Long serie;

  @Column(name = "repetition_executed")
  private Long repetition;

  @Column(name = "load_executed")
  private Long load;

  @Column(name = "finished")
  private Boolean finished;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "workout_id", nullable = false)
  private WorkoutEntity workout;

  @ManyToOne
  @JoinColumn(name = "exercise_id", nullable = false)
  private ExerciseEntity exercise;
}

package com.aju.fit.ajufit.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "workout")
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_created")
  @CreationTimestamp
  private LocalDateTime dateCreated;

  @Column(name = "date_last_updated")
  @UpdateTimestamp
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

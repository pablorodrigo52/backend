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

@Data
@Entity
@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_created")
  @CreationTimestamp
  private LocalDateTime dateCreated;

  @ManyToOne
  @JoinColumn(name = "anamnesis_id", nullable = false)
  private AnamnesisEntity anamnesis;

  @OneToMany(mappedBy = "question")
  private Set<AnamnesisAnwserEntity> anamnesisAnwser;
}

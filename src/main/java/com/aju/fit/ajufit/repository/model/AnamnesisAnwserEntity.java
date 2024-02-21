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
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name = "anamnesis_anwser")
@NoArgsConstructor
@AllArgsConstructor
public class AnamnesisAnwserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_created")
  @CreationTimestamp
  private LocalDateTime dateCreated;

  @Column(name = "answer")
  private String answer;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "anamnesis_id", nullable = false)
  private AnamnesisEntity anamnesis;

  @ManyToOne
  @JoinColumn(name = "question_id", nullable = false)
  private QuestionEntity question;
}

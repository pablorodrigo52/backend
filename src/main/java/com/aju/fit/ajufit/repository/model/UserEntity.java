package com.aju.fit.ajufit.repository.model;

import com.aju.fit.ajufit.statics.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_last_updated")
  private LocalDateTime dateLastUpdated;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private UserType type;

  @Column(name = "social_media")
  private String socialMedia;

  @Column(name = "profile_picture")
  private Blob profilePicture;

  @OneToMany(mappedBy = "professor")
  private Set<UserSubscriptionEntity> professor;

  @OneToMany(mappedBy = "student")
  private Set<UserSubscriptionEntity> student;

  @OneToMany(mappedBy = "user")
  private Set<WorkoutEntity> workouts;

  @OneToMany(mappedBy = "user")
  private Set<ExecutionEntity> executions;

  @OneToMany(mappedBy = "professor")
  private Set<AnamnesisEntity> anamnesis;

  @OneToMany(mappedBy = "user")
  private Set<AnamnesisAnwserEntity> anamnesisAnwser;
}

package com.aju.fit.ajufit.repository.model;

import com.aju.fit.ajufit.model.UserDto;
import com.aju.fit.ajufit.model.UserProfessorDto;
import com.aju.fit.ajufit.statics.UserType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(
    name = "user",
    indexes = {
      @Index(columnList = "email", unique = true),
      @Index(columnList = "phone", unique = true),
      @Index(columnList = "email, phone", unique = true)
    })
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date_created")
  @CreationTimestamp
  private LocalDateTime dateCreated;

  @Column(name = "date_last_updated")
  @UpdateTimestamp
  private LocalDateTime dateLastUpdated;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "phone", unique = true)
  private String phone;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private UserType type;

  @Column(name = "social_media")
  private String socialMedia;

  @Column(name = "profile_picture")
  private Blob profilePicture;

  @Column(name = "is_active")
  private Boolean isActive;

  @OneToOne(mappedBy = "professor", cascade = CascadeType.PERSIST)
  @JsonManagedReference
  @JsonBackReference
  private UserSubscriptionEntity professor;

  @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
  @JsonManagedReference
  @JsonBackReference
  private Set<UserSubscriptionEntity> student;

  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
  @JsonManagedReference
  @JsonBackReference
  private Set<WorkoutEntity> workouts;

  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
  @JsonManagedReference
  @JsonBackReference
  private Set<ExecutionEntity> executions;

  @OneToMany(mappedBy = "professor", cascade = CascadeType.PERSIST)
  @JsonManagedReference
  @JsonBackReference
  private Set<AnamnesisEntity> anamnesis;

  @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
  @JsonManagedReference
  @JsonBackReference
  private Set<AnamnesisAnwserEntity> anamnesisAnwser;

  public UserDto toDto() throws SQLException {
    final var userBuilder =
        UserDto.builder()
            .id(id)
            .dateCreated(dateCreated)
            .email(email)
            .phone(phone)
            .name(name)
            .socialMedia(socialMedia)
            .type(type)
            .isActive(isActive)
        //            .profilePicture(profilePicture.getBytes(1, (int) profilePicture.length()))
        ;

    if (professor != null) {
      userBuilder.professor(
          UserProfessorDto.builder()
              .phone(this.professor.getProfessor().getPhone())
              .email(this.professor.getProfessor().getEmail())
              .build());
    }

    return userBuilder.build();
  }
}

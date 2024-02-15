package com.aju.fit.ajufit.repository.model;

import com.aju.fit.ajufit.repository.model.keys.UserSubscriptionKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "user_subscription")
public class UserSubscriptionEntity {
  @EmbeddedId private UserSubscriptionKey id;

  @ManyToOne
  @MapsId("professorId")
  @JoinColumn(name = "professor_id")
  private UserEntity professor;

  @ManyToOne
  @MapsId("studentId")
  @JoinColumn(name = "student_id")
  private UserEntity student;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_last_updated")
  private LocalDateTime dateLastUpdated;
}

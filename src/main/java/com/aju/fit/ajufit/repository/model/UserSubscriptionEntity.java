package com.aju.fit.ajufit.repository.model;

import com.aju.fit.ajufit.repository.model.keys.UserSubscriptionKey;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "user_subscription")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSubscriptionEntity {
  @EmbeddedId private UserSubscriptionKey id;

  @OneToOne(cascade = CascadeType.PERSIST)
  @MapsId("professorId")
  @JoinColumn(name = "professor_id", referencedColumnName = "id")
  private UserEntity professor;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @MapsId("studentId")
  @JoinColumn(name = "student_id")
  private UserEntity student;

  @Column(name = "date_created")
  @CreationTimestamp
  private LocalDateTime dateCreated;

  @Column(name = "date_last_updated")
  @UpdateTimestamp
  private LocalDateTime dateLastUpdated;

  @Column(name = "is_active")
  private Boolean isActive;
}

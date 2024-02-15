package com.aju.fit.ajufit.repository.model;

import com.aju.fit.ajufit.repository.model.keys.UserSubscriptionKey;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_subscription")
public class UserSubscriptionEntity {
    @EmbeddedId
    private UserSubscriptionKey id;
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

package com.aju.fit.ajufit.repository.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserSubscriptionKey implements Serializable {
  @Column(name = "professor_id")
  private Long professorId;

  @Column(name = "student_id")
  private Long studentId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserSubscriptionKey)) return false;
    final UserSubscriptionKey comparedKey = (UserSubscriptionKey) o;
    return Objects.equals(professorId, comparedKey.professorId)
        && Objects.equals(studentId, comparedKey.studentId);
  }
}

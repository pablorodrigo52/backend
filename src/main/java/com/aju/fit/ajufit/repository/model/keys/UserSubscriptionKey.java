package com.aju.fit.ajufit.repository.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserSubscriptionKey implements Serializable {
    @Column(name = "professor_id")
    private Long professorId;
    @Column(name = "student_id")
    private Long studentId;
}

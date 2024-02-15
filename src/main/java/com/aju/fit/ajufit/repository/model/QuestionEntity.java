package com.aju.fit.ajufit.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @ManyToOne
    @JoinColumn(name = "anamnesis_id", nullable = false)
    private AnamnesisEntity anamnesis;
    @OneToMany(mappedBy = "question")
    private Set<AnamnesisAnwserEntity> anamnesisAnwser;
}

package com.aju.fit.ajufit.repository.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "anamnesis")
public class AnamnesisEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @Column(name = "date_last_updated")
    private LocalDateTime dateLastUpdated;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private UserEntity professor;
    @OneToMany(mappedBy = "anamnesis")
    private Set<QuestionEntity> questions;
    @OneToMany(mappedBy = "anamnesis")
    private Set<AnamnesisAnwserEntity> anamnesisAnwser;
}

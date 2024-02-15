package com.aju.fit.ajufit.repository.model;

import com.aju.fit.ajufit.statics.UserType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Blob;
import java.time.LocalDateTime;

@Data
@Entity
@EntityScan
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @Column(name = "date_last_updated")
    private LocalDateTime dateLastUpdated;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "type")
    private UserType type;
    @Column(name = "social_media")
    private String socialMedia;
    @Column(name = "profile_picture")
    private Blob profilePicture;
}

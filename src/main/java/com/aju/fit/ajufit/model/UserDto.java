package com.aju.fit.ajufit.model;

import com.aju.fit.ajufit.repository.model.UserEntity;
import com.aju.fit.ajufit.statics.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.sql.SQLException;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
    @JsonProperty(index = 1) Long id,
    @NotNull(message = "Email cannot be null")
        @NotEmpty(message = "Email cannot be empty")
        @Email(message = "Invalid email")
        String email,
    @NotNull(message = "Phone cannot be null") @NotEmpty(message = "Phone cannot be empty")
        String phone,
    @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty")
        String name,
    @NotNull(message = "User type cannot be null") UserType type,
    @JsonProperty("social_media") String socialMedia,
    @JsonProperty("profile_picture") byte[] profilePicture,
    @JsonProperty("is_active") Boolean isActive,
    LocalDateTime dateCreated,
    UserProfessorDto professor) {
  public UserEntity.UserEntityBuilder toUserEntity() throws SQLException {
    return UserEntity.builder()
        .email(email)
        .phone(phone)
        .name(name)
        .type(type)
        .socialMedia(socialMedia)
        //                .profilePicture(new SerialBlob(profilePicture))
        .isActive(Boolean.TRUE);
  }
}

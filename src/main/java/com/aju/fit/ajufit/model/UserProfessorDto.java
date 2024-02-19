package com.aju.fit.ajufit.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserProfessorDto(@NotNull @NotEmpty String phone, @NotNull @NotEmpty String email) {}

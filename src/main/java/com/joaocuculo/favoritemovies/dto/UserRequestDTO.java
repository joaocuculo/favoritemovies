package com.joaocuculo.favoritemovies.dto;

import com.joaocuculo.favoritemovies.entities.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
    @NotBlank String name,
    @NotBlank @Email String email,
    @NotBlank String password
) {}

package org.example.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank
        String email,
        @NotBlank
        String password
) { }

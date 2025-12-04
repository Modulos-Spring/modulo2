package org.example.dto;

import jakarta.validation.constraints.NotBlank;

public record SignUpDto (
        @NotBlank
        String email,
        @NotBlank
        String password
) { }

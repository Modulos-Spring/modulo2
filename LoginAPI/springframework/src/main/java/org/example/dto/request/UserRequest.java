package org.example.dto.request;

public record UserRequest(
        String email,
        String password
) {
}

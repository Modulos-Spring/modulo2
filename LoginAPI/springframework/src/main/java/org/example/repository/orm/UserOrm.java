package org.example.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
public record UserOrm(
        @Id
        String id,
        String email,
        String password
) {
}

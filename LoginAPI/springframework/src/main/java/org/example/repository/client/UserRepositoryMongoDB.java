package org.example.repository.client;

import org.example.repository.orm.UserOrm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositoryMongoDB extends MongoRepository<UserOrm, String> {
    Optional<UserOrm> findByEmail(String email);
}

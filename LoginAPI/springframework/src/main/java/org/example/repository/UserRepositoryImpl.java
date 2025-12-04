package org.example.repository;

import org.example.entity.User;
import org.example.exception.InternalServerException;
import org.example.exception.NotFoundException;
import org.example.repository.adapter.UserRepositoryAdapter;
import org.example.repository.client.UserRepositoryMongoDB;
import org.example.repository.orm.UserOrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private final UserRepositoryMongoDB repository;
    private final UserRepositoryAdapter adapter;
    private final PasswordEncoder encoder;

    public UserRepositoryImpl(UserRepositoryMongoDB repository, UserRepositoryAdapter adapter, PasswordEncoder encoder) {
        this.repository = repository;
        this.adapter = adapter;
        this.encoder = encoder;
    }

    @Override
    public User save(User user) {
        try {
            UserOrm orm = UserRepositoryAdapter.cast(user);
            return UserRepositoryAdapter.cast(orm, encoder);

        } catch (Exception ex) {
            LOG.error("Erro ao cadastrar usuario: {}", ex.getMessage());
            throw new InternalServerException(ex);
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            Optional<UserOrm> optional = repository.findByEmail(email);
            if (optional.isEmpty()) {
                throw new NotFoundException("O usuario nao existe");
            }

            return UserRepositoryAdapter.cast(optional.get(), encoder);

        } catch (NotFoundException ex) {
            LOG.info("Usuario nao encontrado");
            throw ex;
        } catch (Exception ex) {
            LOG.error("Erro ao procurar usuario pelo email: {} ", ex.getMessage());
            throw new InternalServerException(ex);
        }
    }
}

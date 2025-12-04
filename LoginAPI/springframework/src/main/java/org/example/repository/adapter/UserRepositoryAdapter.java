package org.example.repository.adapter;

import org.example.entity.User;
import org.example.repository.orm.UserOrm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter {
    public UserRepositoryAdapter() {}

    public static UserOrm cast(User user) {
        return new UserOrm(
                user.id(),
                user.email(),
                user.password()
        );
    }

    public static User cast(UserOrm orm, PasswordEncoder encoder) {
        return new User(
                orm.id(),
                orm.email(),
                encoder.encode(orm.password())
        );
    }

}

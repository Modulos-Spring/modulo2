package org.example.adapter;

import org.example.dto.request.UserRequest;
import org.example.entity.User;

import java.util.UUID;

public class UserControllerAdapter {

    private UserControllerAdapter(){}

    public static User cast(UserRequest request) {
        return new User(
                UUID.randomUUID().toString(),
                request.email(),
                request.password()
        );
    }
}

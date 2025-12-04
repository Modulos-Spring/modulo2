package org.example.controller;

import org.example.repository.UserRepository;
import org.example.security.JwtTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenService token;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.token = jwtTokenService;
    }

    // ========== SIGNUP ==========

    //@PostMapping("/signup")


    // ========== LOGIN ==========

    //@PostMapping("/login")

}

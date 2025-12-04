package org.example.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenService {

    @Value("${security.jwt.secret-key}")
    private String secret;

    public String generateToken(User user) {
        return Jwts.builder()
                .issuer("auth")
                .subject(user.id())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600_000))
                .signWith(Keys.hmacShaKeyFor( secret.getBytes()), Jwts.SIG.HS256 )
                .compact();
    }
}

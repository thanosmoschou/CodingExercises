package com.thanos.secure_book_api_v2.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    private Environment env;

    private final String SECRET_KEY;
    private final long EXPIRATION_TIME;

    @Autowired
    public JwtUtil(Environment env) {
        this.env = env;
        this.SECRET_KEY = env.getProperty("SECRET_KEY");
        this.EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(Integer.parseInt(env.getProperty("EXPIRATION_TIME")));
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        List<String> roles = userDetails.getAuthorities().stream() // Get authorities (roles)
                .map(GrantedAuthority::getAuthority) // Extract the role string, :: is a method reference
                .map(role -> role.startsWith("ROLE_") ? role.substring(5) : role) // Remove the ROLE_ prefix if exists
                .collect(Collectors.toList());

        claims.put("roles", roles);

        return Jwts.builder() // Initializes a new JWT
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact(); // Generates the final JWT string
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration()
                .before(new Date());
    }
}

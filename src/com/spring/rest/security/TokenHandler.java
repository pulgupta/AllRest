package com.spring.rest.security;

import org.springframework.security.core.userdetails.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenHandler {

    private final String secret;
    private final UserService userService;

    public TokenHandler(String secret, UserService userService) {
        this.secret = secret;
        this.userService = userService;
    }

    /**
     * Will give us the user back from the token
     * @param token
     * @return user who has logged in
     */
    public User parseUserFromToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return userService.loadUserByUsername(username);
    }

    /**
     * This method will create a token
     * @param user
     * @return a token based on user details and hashing algorithm
     */
    public String createTokenForUser(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}

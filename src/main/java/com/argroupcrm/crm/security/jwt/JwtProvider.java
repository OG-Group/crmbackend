package com.argroupcrm.crm.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Created by ogbozoyan at 14.01.2023
 * github.com/ogbozoyan
 */
@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.secret}")
    private String JWT_SIGN_SECRET;
    @Value("${jwt.expiration}")
    private int jwtExpirationIn;

    public String jwtGenerate(Authentication authentication) {
        log.info("JwtGeneration: ");
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(Date.from(Instant.now())).setExpiration(Date.from(Instant.now().plus(jwtExpirationIn, MINUTES))).signWith(SignatureAlgorithm.HS512, JWT_SIGN_SECRET).compact();
    }

    public boolean validateToken(String token) {
        log.info("validateToken: " + token);
        try {
            Jwts.parser().setSigningKey(JWT_SIGN_SECRET).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            System.out.println("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            System.out.println("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            System.out.println("Malformed jwt");
        } catch (Exception e) {
            System.out.println("invalid token");
        }
        return false;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SIGN_SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
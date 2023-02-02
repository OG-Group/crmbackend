package com.argroupcrm.crm.security;


import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;

@Component
@Slf4j
public class JwtProvider {

    //@Value(value = "${jwt.secret}")
    private String JWT_SIGN_SECRET = "secret";
    //@Value(value = "${jwt.expiration}")
    private int jwtExpirationIn = 1;
    public String jwtGenerate(Authentication authentication){
        log.info("JwtGeneration: ");
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(jwtExpirationIn, HOURS)))
                .signWith(SignatureAlgorithm.HS512, JWT_SIGN_SECRET)
                .compact();
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

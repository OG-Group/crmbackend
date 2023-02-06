package com.argroupcrm.crm.security.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String login;

    public JwtResponse(String accessToken,String login){
        this.token = accessToken;
        this.login = login;

    }
}

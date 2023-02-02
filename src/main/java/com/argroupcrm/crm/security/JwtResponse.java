package com.argroupcrm.crm.security;

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
    private String refreshToken;

    public JwtResponse(String accessToken,String login,String refresh){
        this.token = accessToken;
        this.login = login;
        this.refreshToken = refresh;
    }
}

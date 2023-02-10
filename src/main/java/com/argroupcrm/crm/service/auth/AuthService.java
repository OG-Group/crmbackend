package com.argroupcrm.crm.service.auth;

import com.argroupcrm.crm.dto.auth.LoginDTO;
import com.argroupcrm.crm.security.jwt.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService  {

    ResponseEntity<JwtResponse> signIn (LoginDTO loginDTO);
}

package com.argroupcrm.crm.service;

import com.argroupcrm.crm.dto.LoginDTO;
import com.argroupcrm.crm.security.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<JwtResponse> signIn(LoginDTO loginDTO);
}

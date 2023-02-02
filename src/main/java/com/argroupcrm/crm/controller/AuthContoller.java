package com.argroupcrm.crm.controller;

import com.argroupcrm.crm.dto.LoginDTO;
import com.argroupcrm.crm.dto.SignUpDTO;
import com.argroupcrm.crm.security.JwtResponse;
import com.argroupcrm.crm.service.AuthService;
import com.argroupcrm.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthContoller {
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDTO signUpDTO){
        log.info("signUp");

        return userService.signUp(signUpDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginDTO loginDTO) {
        return authService.signIn(loginDTO);
    }
}

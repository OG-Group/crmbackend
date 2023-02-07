package com.argroupcrm.crm.generic.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AbstractAuthController<T extends AbstractAuthEntity> {
    @PostMapping("/signup")
    ResponseEntity<?> signUp(@Valid @RequestBody Object signUpDTO);
}

package com.argroupcrm.crm.service;

import com.argroupcrm.crm.dto.SignUpDTO;
import com.argroupcrm.crm.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {
    boolean exist(String login, String email);

    ResponseEntity<UserEntity> signUp(SignUpDTO signUpDTO);

    UserEntity findByLogin(String username);
}

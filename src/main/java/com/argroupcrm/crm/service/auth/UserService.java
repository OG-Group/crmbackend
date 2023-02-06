package com.argroupcrm.crm.service.auth;

import com.argroupcrm.crm.dto.auth.SignUpDTO;
import com.argroupcrm.crm.model.auth.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {
    boolean exist(String login);

    ResponseEntity<UserEntity> signUp(SignUpDTO signUpDTO);

    UserEntity findByLogin(String username);

    UserEntity getCurrent() throws Exception;
}

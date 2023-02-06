package com.argroupcrm.crm.service;

import com.argroupcrm.crm.dto.SignUpDTO;
import com.argroupcrm.crm.model.UserEntity;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    boolean exist(String login);

    ResponseEntity<UserEntity> signUp(SignUpDTO signUpDTO);

    UserEntity findByLogin(String username);

    UserEntity getCurrent() throws Exception;
}

package com.argroupcrm.crm.service.auth;

import com.argroupcrm.crm.dto.auth.SignUpDTO;
import com.argroupcrm.crm.generic.crud.AbstractService;
import com.argroupcrm.crm.model.auth.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService extends AbstractService<UserEntity> {
    boolean exist(String login);

    ResponseEntity<UserEntity> signUp(SignUpDTO signUpDTO);

    UserEntity findByLogin(String username);

    UserEntity getCurrent() throws Exception;
    @Override
    UserEntity save(UserEntity entity);
}

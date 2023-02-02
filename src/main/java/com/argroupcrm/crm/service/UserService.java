package com.argroupcrm.crm.service;

import com.argroupcrm.crm.dto.SignUpDTO;
import com.argroupcrm.crm.model.UserEntity;

public interface UserService {
    boolean exist(String login, String email);

    UserEntity signUp(SignUpDTO signUpDTO);
}

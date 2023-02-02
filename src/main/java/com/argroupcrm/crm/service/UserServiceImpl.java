package com.argroupcrm.crm.service;

import com.argroupcrm.crm.dto.SignUpDTO;
import com.argroupcrm.crm.model.UserEntity;
import com.argroupcrm.crm.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserEntityRepository userRepository;
    @Override
    public boolean exist(String login, String email) {
        return false;
    }

    @Override
    public UserEntity signUp(SignUpDTO signUpDTO) {
        return null;
    }
}

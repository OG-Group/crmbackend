package com.argroupcrm.crm.service;

import com.argroupcrm.crm.dto.SignUpDTO;
import com.argroupcrm.crm.model.RoleEntity;
import com.argroupcrm.crm.model.UserEntity;
import com.argroupcrm.crm.repository.RoleEntityRepository;
import com.argroupcrm.crm.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleEntityRepository roleEntityRepository;
    @Override
    public boolean exist(String login, String email) {
        return false;
    }

    @Override
    @Transactional
    public ResponseEntity<UserEntity> signUp(SignUpDTO signUpDTO) {
        log.info("signUp");
        Set<RoleEntity> role = new HashSet<>();
        role.add(roleEntityRepository.findByName("ROLE_USER"));
        UserEntity user = userRepository.findByLogin(signUpDTO.getLogin());
        if (user != null){
            log.info("signUp failed 409");
            return ResponseEntity.status(409).build();
        }
        else {
            UserEntity newUser = new UserEntity();
            newUser.setLogin(signUpDTO.getLogin());
            newUser.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
            newUser.setPhone(signUpDTO.getPhone());
            newUser.setRoles(role);
            newUser.setName(signUpDTO.getName());
            userRepository.save(newUser);
            log.info("signUp success 200");
            return ResponseEntity.ok(newUser);
        }
    }

    @Override
    public UserEntity findByLogin(String username) {
        return userRepository.findByLogin(username);
    }
}

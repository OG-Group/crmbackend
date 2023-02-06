package com.argroupcrm.crm.service.auth;

import com.argroupcrm.crm.dto.auth.SignUpDTO;
import com.argroupcrm.crm.model.auth.RoleEntity;
import com.argroupcrm.crm.model.auth.UserEntity;
import com.argroupcrm.crm.repository.auth.RoleEntityRepository;
import com.argroupcrm.crm.repository.auth.UserEntityRepository;
import com.argroupcrm.crm.security.jwt.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleEntityRepository roleEntityRepository;

    @Override
    public boolean exist(String login) {
        return userRepository.findByLogin(login) != null;
    }

    @Override
    @Transactional
    public ResponseEntity<UserEntity> signUp(SignUpDTO signUpDTO) {
        log.info("signUp");
        Set<RoleEntity> role = new HashSet<>();
        role.add(roleEntityRepository.findByName("ROLE_USER"));
        UserEntity user = userRepository.findByLogin(signUpDTO.getLogin());
        if (user != null) {
            log.info("signUp failed 409");
            return ResponseEntity.status(409).build();
        } else {
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
    @Transactional
    public UserEntity findByLogin(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity getCurrent() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (auth == null) {
            throw new Exception("UserService.getCurrentUser(): Ошибка получения аутентификационных данных");
        }
        Object principal = auth.getPrincipal();
        String userInfo;
        System.out.println(principal);
        if (principal instanceof CustomUserDetails) {
            userInfo = ((CustomUserDetails) principal).getUsername();
            return findByLogin(userInfo);
        } else {
            throw new Exception("UserService.getCurrentUser(): Ошибка получения данных о пользователе");
        }
    }

}

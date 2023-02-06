package com.argroupcrm.crm.controller;

import com.argroupcrm.crm.model.UserEntity;
import com.argroupcrm.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<UserEntity> getUser() {
        log.info("getUser");
        try {
            return ResponseEntity.ok(userService.getCurrent());
        } catch (Exception e) {
            log.error("getUser error ", e);
            return ResponseEntity.badRequest().build();
        }
    }
}

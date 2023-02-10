package com.argroupcrm.crm.generic.crud;

import com.argroupcrm.crm.service.auth.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component("auditorAware")
@RequiredArgsConstructor
public class AuditAwareImpl implements AuditorAware<String> {
    private final UserServiceImpl userService;
    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            System.out.println("user login: " + userService.getCurrent().getLogin());
            return Optional.of(userService.getCurrent().getLogin());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


package com.argroupcrm.crm.generic.crud;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
//TODO: implement
@Component
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
     //    UserDetails = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //return Optional.of(principal.getId());
        return null;
    }
}


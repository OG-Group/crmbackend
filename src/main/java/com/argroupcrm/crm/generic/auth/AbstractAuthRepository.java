package com.argroupcrm.crm.generic.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractAuthRepository<T extends AbstractAuthEntity> extends JpaRepository<AbstractAuthEntity, Long> {
}

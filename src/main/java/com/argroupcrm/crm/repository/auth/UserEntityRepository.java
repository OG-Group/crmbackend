package com.argroupcrm.crm.repository.auth;

import com.argroupcrm.crm.generic.auth.AbstractAuthRepository;
import com.argroupcrm.crm.model.auth.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends AbstractAuthRepository<UserEntity> {
    UserEntity findByLogin(String username);
}

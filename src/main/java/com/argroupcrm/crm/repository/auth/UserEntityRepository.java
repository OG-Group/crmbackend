package com.argroupcrm.crm.repository.auth;

import com.argroupcrm.crm.generic.crud.AbstractRepository;
import com.argroupcrm.crm.model.auth.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends AbstractRepository<UserEntity> {
    UserEntity findByLogin(String username);
}

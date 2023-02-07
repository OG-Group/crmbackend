package com.argroupcrm.crm.repository.auth;

import com.argroupcrm.crm.generic.crud.AbstractRepository;
import com.argroupcrm.crm.model.auth.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends AbstractRepository<RoleEntity> {
    RoleEntity findByName(String roleClient);
}

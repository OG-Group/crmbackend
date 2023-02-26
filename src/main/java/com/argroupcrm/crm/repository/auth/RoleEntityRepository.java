package com.argroupcrm.crm.repository.auth;

import com.argroupcrm.crm.model.auth.RoleEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Hidden
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String roleClient);
}

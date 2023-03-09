package com.argroupcrm.crm.generic.crud.repository;

import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, Long>,
        JpaSpecificationExecutor<T> {
}

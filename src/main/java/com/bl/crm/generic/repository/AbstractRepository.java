package com.bl.crm.generic.repository;

import com.bl.crm.generic.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Abstract Repository with Specification Executor
 *
 * @param <E> - Any Entity that extends AbstractEntity
 */
@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
}

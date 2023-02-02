package com.argroupcrm.crm.repository;

import com.argroupcrm.crm.model.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeEntityRepository extends JpaRepository<OfficeEntity, Integer> {
}

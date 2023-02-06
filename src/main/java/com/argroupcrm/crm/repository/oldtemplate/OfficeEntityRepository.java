package com.argroupcrm.crm.repository.oldtemplate;

import com.argroupcrm.crm.model.oldtemplate.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeEntityRepository extends JpaRepository<OfficeEntity, Integer> {
}

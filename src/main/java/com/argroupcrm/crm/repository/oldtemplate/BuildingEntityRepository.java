package com.argroupcrm.crm.repository.oldtemplate;

import com.argroupcrm.crm.model.oldtemplate.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingEntityRepository extends JpaRepository<BuildingEntity, Integer> {
}
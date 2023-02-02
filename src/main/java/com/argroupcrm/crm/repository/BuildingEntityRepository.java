package com.argroupcrm.crm.repository;

import com.argroupcrm.crm.model.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingEntityRepository extends JpaRepository<BuildingEntity, Integer> {
}

package com.argroupcrm.crm.repository;

import com.argroupcrm.crm.model.BuildingCianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingCianRepository extends JpaRepository<BuildingCianEntity, Integer> {
}

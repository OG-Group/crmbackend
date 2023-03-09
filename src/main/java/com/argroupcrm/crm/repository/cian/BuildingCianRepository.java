package com.argroupcrm.crm.repository.cian;

import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingCianRepository extends JpaRepository<BuildingCianEntity,Long> {
}

package com.argroupcrm.crm.repository;

import com.argroupcrm.crm.model.HighwayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighwayEntityRepository extends JpaRepository<HighwayEntity, Integer> {
}

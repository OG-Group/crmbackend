package com.argroupcrm.crm.repository.cian;

import com.argroupcrm.crm.model.cian.HighwayCianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighwayCianRepository extends JpaRepository<HighwayCianEntity, Integer> {
}

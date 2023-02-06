package com.argroupcrm.crm.repository;

import com.argroupcrm.crm.model.OfficeCianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeCianRepository extends JpaRepository<OfficeCianEntity, Integer> {

}

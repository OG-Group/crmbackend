package com.argroupcrm.crm.repository;

import com.argroupcrm.crm.model.MetroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroEntityRepository extends JpaRepository<MetroEntity, Integer> {
}

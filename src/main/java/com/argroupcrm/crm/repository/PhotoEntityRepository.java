package com.argroupcrm.crm.repository;

import com.argroupcrm.crm.model.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoEntityRepository extends JpaRepository<PhotoEntity, Integer> {
}

package com.argroupcrm.crm.repository.cian;

import com.argroupcrm.crm.model.cian.MetroMoscowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroMoscowRepository extends JpaRepository<MetroMoscowEntity, Integer> {
}

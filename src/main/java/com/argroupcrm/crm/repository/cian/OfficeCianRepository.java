package com.argroupcrm.crm.repository.cian;

import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeCianRepository extends JpaRepository<OfficeCianEntity,Long> {

}

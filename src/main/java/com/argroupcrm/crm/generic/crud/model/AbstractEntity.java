package com.argroupcrm.crm.generic.crud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @CreatedBy
    @Column(name = "created_by")
    protected String createdBy;
    @CreatedDate
    @Column(name = "created_date")
    protected Timestamp createdDate;
    @LastModifiedBy
    @Column(name = "updated_by")
    protected String updatedBy;
    @LastModifiedDate
    @Column(name = "updated_date")
    protected Timestamp updatedDate;
}

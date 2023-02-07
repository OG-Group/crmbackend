package com.argroupcrm.crm.generic.crud;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @CreatedBy
//    @Column(name = "created_by")
//    private String createdBy;
//    @CreatedDate
//    @Column(name = "created_date")
//    private String createdDate;
//    @LastModifiedBy
//    @Column(name = "updated_by")
//    private String updatedBy;
//    @LastModifiedDate
//    @Column(name = "updated_date")
//    private String updatedDate;
}

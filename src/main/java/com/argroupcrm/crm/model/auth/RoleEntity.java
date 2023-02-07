package com.argroupcrm.crm.model.auth;

import com.argroupcrm.crm.generic.crud.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends AbstractEntity {
    @Column(name = "name")
    private String name;

}

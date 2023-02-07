package com.argroupcrm.crm.model.auth;

import com.argroupcrm.crm.generic.auth.AbstractAuthEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "userbd")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AbstractAuthEntity {
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;
}

package com.argroupcrm.crm.security;

import com.argroupcrm.crm.model.UserEntity;
import com.argroupcrm.crm.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component

public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            UserEntity user = userService.findByLogin(username);
            return UserDetails.build(user);
        }catch (Exception e){
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
    }
}

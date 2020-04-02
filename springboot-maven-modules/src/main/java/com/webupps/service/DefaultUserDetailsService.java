package com.webupps.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.webupps.model.AppUser;
import com.webupps.repositories.AppUserRepository;

import java.util.Collections;
import java.util.List;


public class DefaultUserDetailsService implements UserDetailsService {
	
    private final AppUserRepository appUserRepository;

    public DefaultUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	
        List<AppUser> userEntity = appUserRepository.findByUserName(username);

        if (userEntity.size()>0) {
            final AppUser appUser = userEntity.get(0);

            return new User(appUser.getUsername(),
                    passwordNoEncoding(appUser),
                    Collections.singletonList(new SimpleGrantedAuthority(appUser.getRole())));
        }

        return null;
    }

    private String passwordNoEncoding(AppUser appUser) {
        return "{noop}" + appUser.getPassword();
    }
}

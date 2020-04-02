package com.webupps.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.webupps.repositories.AppUserRepository;
import com.webupps.service.DefaultUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
    private AppUserRepository userRepository;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {    
        http
        .csrf().disable()
        .authorizeRequests()        	        	
        	.antMatchers("/api/admin/**").hasRole("ADMIN")
        	.anyRequest().authenticated()
        .and()
        .httpBasic().realmName("My-Realm");
    	
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
    	auth.userDetailsService(new DefaultUserDetailsService(userRepository));        
    }
}
package com.spring_security.Spring.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {
    /*meka hadanne project eke sercurity cnofigurations walata.
    * mona pathda access denna one nodenna one ekata api me class eka use karnawa.*/

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                /*ona kenketa mekata access karanna puluwan(url) but authentication ekak thiyenna one*/
                .authorizeRequests()
                .antMatchers("/api/v1/account/my-account","/api/v1/loan/my-loan").authenticated()
                .antMatchers("/api/v1/notice/my-notice").permitAll()
                .and().formLogin().and().httpBasic();
        return http.build();
    }


    @Bean/*meka container ekata dagannawa use karanna kalin.*/
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

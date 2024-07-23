package com.spring_security.Spring.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    /*meka hadanne project eke sercurity cnofigurations walata.
     * mona pathda access denna one nodenna one ekata api me class eka use karnawa.*/

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                /*ona kenketa mekata access karanna puluwan(url) but authentication ekak thiyenna one*/
                .authorizeRequests()
                /*.antMatchers("/api/v1/account/my-account","/api/v1/loan/my-loan").authenticated()*/ // me dekama authenticated wela thiyenne.
                .antMatchers("/api/v1/account/my-account").hasAuthority("admin")//role eka admin nam withrak access denawa
                .antMatchers("/api/v1/loan/my-loan").hasAuthority("user") // role eka user nam access denawa
                .antMatchers("/api/v1/notice/my-notice").permitAll()
                .and().formLogin().and().httpBasic();
        return http.build();
    }


    @Bean/*meka container ekata dagannawa use karanna kalin.*/
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

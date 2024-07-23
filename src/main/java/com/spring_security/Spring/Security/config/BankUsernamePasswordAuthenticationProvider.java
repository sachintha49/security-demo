package com.spring_security.Spring.Security.config;

import com.spring_security.Spring.Security.model.User;
import com.spring_security.Spring.Security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*api me hadagaththa class eka authentication provider ekak karanna spring security visin dena AuthenticationProvider kiyana
 * interface eka implement karanna one*/
@Component
public class BankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepo userRepo;

@Autowired
private PasswordEncoder passwordEncoder;
    /*authentication eka meka athuledi wenne*/
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        /*postman eke header eke thama meka enne Authentication eka*/
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        List<User> users = userRepo.findByEmail(username);

        if (!users.isEmpty()){
            if(passwordEncoder.matches(pwd,users.get(0).getPassword())){
                /*methanin password eka match  nam username password Authentication Token ekka thama return karanna one*/
                /*eta passe me user ta thiyana access monawada kiyala authorities kiyana ekata dala return karanna one*/
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username,pwd,authorities);
            }else{
                throw new BadCredentialsException("Invalid Password!");
            }
        }else {
            throw new BadCredentialsException("No User Registered with this details");
        }
        /*meeta amatharawa authentication ekak wena atharathura thawa monawa hari run wenna one nam api ewa filters wala liyanawa*/
    }

    @Override
    public boolean supports(Class<?> authentication) {
        /*meka samanyen me vidiyata thama hadanne*/
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}


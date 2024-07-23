package com.spring_security.Spring.Security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin
public class AccountController {

    @GetMapping("/my-account")
    @Secured("ROLE_ADMIN")// meka adala vidiyata danna one hasRole() damoth ROLE_ADMIN wage danna one prefix ekath ekka.
    //@PreAuthorize("hasAnyAuthority('user')")
    //PostAuthorize() mekedi wenne return karana kota thamai authorize karanne.
    public String getAccountDetails(){
        return "Here are the account details";
    }
}

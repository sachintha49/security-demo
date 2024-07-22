package com.spring_security.Spring.Security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
@CrossOrigin
public class LoanController {

    @GetMapping("/my-loan")
    public String getMyLoans(){
        return "Here are the loan details";
    }
}

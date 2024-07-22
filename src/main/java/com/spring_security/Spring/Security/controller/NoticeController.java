package com.spring_security.Spring.Security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loan")
@CrossOrigin
public class NoticeController {

    @GetMapping("/my-notice")
    public String getMyLoans(){
        return "Here are the notice details";
    }
}

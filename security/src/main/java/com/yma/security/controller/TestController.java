package com.yma.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/welcome")
    public String test(){
        return "Welcome to test controller";
    }

    @GetMapping("/user")
    public String user(){
        return "Here is the details of users";
    }
}

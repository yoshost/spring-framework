package com.yma.securityjwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<String> home(Principal principal){
        return  ResponseEntity.ok("This is home end point"+ principal.getName());
    }
}

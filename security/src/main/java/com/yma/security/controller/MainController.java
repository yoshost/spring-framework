package com.yma.security.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/welcome")
    public ResponseEntity<String> anyone(){
        return ResponseEntity.ok("Welcome !!");
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> user(Principal principal){
        return ResponseEntity.ok(principal.getName() + "is calling user endpoint");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> admin(Principal principal){
        return ResponseEntity.ok(principal.getName() + "is calling user endpoint");

    }
}

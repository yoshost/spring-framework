package com.yma.securityjwt.controller;

import com.yma.securityjwt.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public ResponseEntity<String> token(Authentication authentication){
        LOG.debug("Token for user: '{}'", authentication.getName());
        String token = tokenService.generateJwt(authentication);
        LOG.debug("Token granted: {}", token);
        return ResponseEntity.ok(token);
    }
}

package com.yma.session.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    private final  String VIEW_COUNT = "VIEW_COUNT";

    @GetMapping("/")
    public ResponseEntity<String> home(Principal principal, HttpSession session) {
        var count = session.getAttribute(VIEW_COUNT) == null ? 0 : (Integer) session.getAttribute("VIEW_COUNT");
        session.setAttribute(VIEW_COUNT, count += 1);
        return ResponseEntity.ok(principal.getName());
    }

    @GetMapping("/count")
    public  ResponseEntity<String> getViewCount(HttpSession httpSession){
        return ResponseEntity.ok(httpSession.getAttribute(VIEW_COUNT).toString());
    }


}

package com.security.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/public")
    String publicAccess() {
        return "<h1>acesso aprovado!</h1>";
    }

    @GetMapping("/private")
    String privateAccess() {
        return "<h1>acesso privado aprovado!</h1>";
    }


}

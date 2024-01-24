package com.security.base.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
    String privateAccess(@AuthenticationPrincipal OidcUser principal) { //OIDC = open id connected
        return String.format("""
                <h1>Rota privada acessada</h1> <br><br>
                <h3>Principal: %s</h3> <br><br>
                <h3>Email attribute: %s </h3> <br><br>
                <h3>Authorities: %s </h3> <br><br>
                <h3>JWT: %s </h3> <br><br>
                """, principal, principal.getAttribute("email"), principal.getAuthorities(), principal.getIdToken().getTokenValue());
    }


}

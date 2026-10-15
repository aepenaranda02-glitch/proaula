package com.almora.almora.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "/", "/index.html" })
    public String index() {
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping("/register.html")
    public String register() {
        return "register";
    }

    @GetMapping("/admin.html")
    public String admin() {
        return "admin";
    }

    @GetMapping("/donante.html")
    public String donante() {
        return "donante";
    }

    @GetMapping("/redirect")
    public String redirectByRole(Authentication auth) {

        for (GrantedAuthority role : auth.getAuthorities()) {
            if (role.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/admin.html";
            }
        }

        return "redirect:/donante.html";
    }
}
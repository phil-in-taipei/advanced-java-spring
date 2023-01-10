package platform.codingnomads.co.springsecurity.authorization.addingauthorization.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "authorization/home";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "authorization/index";
    }

    @GetMapping("/landing")
    public String landingPage() {
        return "authorization/landing";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "authorization/admin";
    }

    @GetMapping("/superu")
    public String superUPage() {
        return "authorization/superu";
    }

    @GetMapping("/fantastic")
    public String fantasticPage() {
        return "authorization/fantastic";
    }

    @GetMapping("/mas")
    @PreAuthorize("#id != 1")
    public String testMas(int id){
        return "authorization/home";
    }

    /*
        Method Security Annotations

        @RolesAllowed("USER")
        @PreAuthorize("#id != 1")
        @PostAuthorize("returnObject.ownerUsername == authentication.principal.username")
        @PreFilter(value = "filterObject != shutdown", filterTarget = "commands")
        @PostFilter("filterObject.id <= 20")
     */
}
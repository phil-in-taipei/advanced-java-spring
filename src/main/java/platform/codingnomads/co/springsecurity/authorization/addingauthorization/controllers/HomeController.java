package platform.codingnomads.co.springsecurity.authorization.addingauthorization.controllers;

import platform.codingnomads.co.springsecurity.authorization.addingauthorization.services.CustomUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private  CustomUserService customUserService;

    @GetMapping("/")
    public String homePage() {
        return "authorization/home";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "authorization/index";
    }

    @RolesAllowed("ADMIN")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/expired-users")
    public String expiredUsersPage(Model model) {
        final List<UserPrincipal> expiredUsersList = customUserService.getAllUsersWithExpiredCredentials();
        System.out.println(expiredUsersList);
        // Once the customers are retrieved, you can store them in model and return it to the view
        model.addAttribute("expiredUsersList", expiredUsersList);
        return "authorization/expired-users";
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
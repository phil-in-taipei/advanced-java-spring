package platform.codingnomads.co.springsecurity.authorization.custompermissions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.services.UserService;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home() {
        return "permissions";
    }

    @GetMapping("/user")
    @ResponseBody
    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public User getEntityById(@RequestParam String email) {
        return userService.getUser(email);
    }

    /*
    @GetMapping("/username")
    @ResponseBody
    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public User getEntityByUsername(@RequestParam String username) {
        return userService.getUser(username);
    } */

    @GetMapping("/user/delete/{id}")
    @ResponseBody
    @PreAuthorize("hasPermission(#id, 'platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User', 'DELETE')")
    public String deleteEntity(@PathVariable Long id) {
        userService.deleteUser(id);
        return ("deleted user with id: " + id);
    }

    /*
    @PatchMapping("/user/update/{id}")
    @ResponseBody
    @PreAuthorize("hasPermission(#id, 'platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User', 'EDIT')")
    public String updateEntity(@PathVariable Long id) {
        User updatedUser = userService.findById(id);
        userService.updateUser(updatedUser);
        return ("Updated user with id: " + id);
    }

     */

}

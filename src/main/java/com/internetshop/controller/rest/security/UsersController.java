package com.internetshop.controller.rest.security;

import com.internetshop.entity.security.User;
import com.internetshop.service.security.UsersService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
public class UsersController {

    private final UsersService usersService;

    @PutMapping("user")
    public User addUser(@RequestBody User newUser) {
        return usersService.addUser(newUser);
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return usersService.getUserById(id);
    }

    @DeleteMapping("user/{id}")
    public boolean deleteUser(@PathVariable("id") Long id) {
        return usersService.deleteUser(id);
    }
}

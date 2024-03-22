package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class TestController {
    private List<User> users = new ArrayList<>();

    @GetMapping("/")
    public List<User> getUsers() {
        return users;
    }

    @PostMapping("/")
    public User addUser(@RequestBody  User user) {
        users.add(user);
        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        User userToUpdate = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
        }
        return userToUpdate;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable String id) {
        User userToDelete = users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
        if (userToDelete != null) {
            users.remove(userToDelete);
        }
        return userToDelete;
    }


}

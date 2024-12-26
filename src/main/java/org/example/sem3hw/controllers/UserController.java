package org.example.sem3hw.controllers;

import org.example.sem3hw.domain.User;
import org.example.sem3hw.services.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private RegService service;

    @GetMapping("/users")
    public List<User> userList(){
        return service.getDps().getRepo().getUsers();
    }

    @PostMapping("/create")
    public String create(@RequestBody Map<String, Object> body){
        String name = (String) body.get("name");
        String email = (String) body.get("email");
        int age = (int) body.get("age");
        service.createUser(name, age, email);
        return "User " + name + " created!";
    }
}

package org.example.sem3hw.controllers;

import org.example.sem3hw.domain.User;
import org.example.sem3hw.services.DataProcessingService;
import org.example.sem3hw.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    @Autowired
    DataProcessingService dps;

    @GetMapping
    public List<String> getTasks(){
        return new ArrayList<String>(Arrays.asList("calculate", "sort", "filter"));
    }

    @GetMapping("/calculate")
    public double calculate(){
        return dps.calculate(dps.getRepo().getUsers());
    }

    @GetMapping("/sort")
    public List<User> sort(){
        return dps.sort(dps.getRepo().getUsers());
    }

    @GetMapping("/filter{age}")
    public List<User> filter(@RequestBody Map<String, Integer> request){
        return dps.filter(dps.getRepo().getUsers(), request.get("age"));
    }

}

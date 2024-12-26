package org.example.sem3hw.services;

import org.example.sem3hw.domain.User;
import org.example.sem3hw.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepo repo;

    public double calculate(List<User> users){
        return users.stream().mapToInt(value -> value.getAge()).average().orElse(0);
    }

    public List<User> filter(List<User> users, int age){
        return users.stream().filter(user -> user.getAge() > age).collect(Collectors.toList());
    }

    public List<User> sort(List<User> users){
        return users.stream().sorted(Comparator.comparing(user -> user.getAge())).collect(Collectors.toList());
    }

    public void addUser(User user){
        repo.getUsers().add(user);
    }

    public UserRepo getRepo() {
        return repo;
    }
}

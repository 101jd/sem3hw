package org.example.sem3hw.repos;

import org.example.sem3hw.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserRepo {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
}

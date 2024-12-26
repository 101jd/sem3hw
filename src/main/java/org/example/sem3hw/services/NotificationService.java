package org.example.sem3hw.services;

import org.example.sem3hw.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println(user.getName() + " created");
    }
}

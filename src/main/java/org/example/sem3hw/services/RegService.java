package org.example.sem3hw.services;

import org.example.sem3hw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/*TODO:
    RegService
    <- user data
    createuser here
    DPS.addToList(user)
    NS.notify

 */
@Service
public class RegService {
    @Autowired
    private UserService userService;
    @Autowired
    private DataProcessingService dps;
    @Autowired
    private NotificationService notificationService;


    public void createUser(String name, int age, String email){
        User user = userService.create(name, age, email);
        dps.addUser(user);
        notificationService.notifyUser(user);
    }

    public DataProcessingService getDps() {
        return dps;
    }
}

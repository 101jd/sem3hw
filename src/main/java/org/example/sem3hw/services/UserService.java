package org.example.sem3hw.services;

import org.example.sem3hw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*TODO:
    RegService
    <- user data
    createuser here
    DPS.addToList(user)
    NS.notify
TODO:
    UserRepo: @Component
    private List
    DPS -- Autowired Repo
    ***
    @RequestMapping: (/)TaskC, (/)UserC: @RestController
    tasks -- private Autowired DPS,
    @GetMapping
*/

@Component
public class UserService {
    @Autowired
    private NotificationService notificationService;

    public User create(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        notificationService.notifyUser(user);
        return user;
    }
}

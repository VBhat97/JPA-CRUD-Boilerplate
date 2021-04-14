package com.jpa;

import com.jpa.entity.User;
import com.jpa.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Autowired
    private UserDAOService userDaoService;


    @Override
    public void run(String... args) throws Exception {
        // This is the entry point for CRUD operatiors on the database.
        User user = new User("Vaibhav","admin");
        User user2 = new User("Nihdi","user");
        long insert = userDaoService.insert(user);
        User returned_user = userDaoService.getUserById(1);
        long insert2 = userDaoService.insert(user2);

        log.info("New User is created : "+user);
        log.info("The retained user is : "+returned_user);

        userDaoService.updateUser(user2);
        userDaoService.deleteUser(user.getId());
    }
}

package com.example.home.MongoDB.Spring.Boot.controller;

import com.example.home.MongoDB.Spring.Boot.dao.UserDao;
import com.example.home.MongoDB.Spring.Boot.dao.UserRepository;
import com.example.home.MongoDB.Spring.Boot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

  //  @Autowired
   // private final UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public UserController(UserRepository userRepository, UserDao userDao) {
        //this.userRepository = userRepository;
        this.userDao = userDao;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        logger.info("Getting all users.");
        //return userDao.getAllUsers();
        return  userDao.getAllUsers();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId) {
        logger.info("Getting user with ID: {}.", userId);
        return userDao.getUserById(userId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User addNewUsers(@RequestBody User user) {
        logger.info("Saving user.");
        //return userDao.addNewUser(user);
        return userDao.addNewUser(user);
    }

    @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
    public Object getAllUserSettings(@PathVariable String userId) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            return user.getUserSettings();
        } else {
            return "User not found.";
        }
    }

    @RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
    public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            return user.getUserSettings().get(key);
        } else {
            return "User not found.";
        }
    }

    @RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
    public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
        User user = userDao.getUserById(userId);
        if (user != null) {
            user.getUserSettings().put(key, value);
            userDao.addNewUser(user);
            return "Key added";
        } else {
            return "User not found.";
        }
    }
}

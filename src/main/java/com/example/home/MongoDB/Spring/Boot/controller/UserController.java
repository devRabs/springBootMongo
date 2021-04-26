package com.example.home.MongoDB.Spring.Boot.controller;

import com.example.home.MongoDB.Spring.Boot.MongoDbSpringBootApplication;
import com.example.home.MongoDB.Spring.Boot.config.DefaultExceptionThrowConfig;
import com.example.home.MongoDB.Spring.Boot.config.PropertiesConfiguration;
import com.example.home.MongoDB.Spring.Boot.dao.UserDao;
import com.example.home.MongoDB.Spring.Boot.dao.UserRepository;
import com.example.home.MongoDB.Spring.Boot.exception.AppException;
import com.example.home.MongoDB.Spring.Boot.model.User;
import com.example.home.MongoDB.Spring.Boot.service.UserSerice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PropertiesConfiguration propertiesConfiguration;
  //  @Autowired
   // private final UserRepository userRepository;

    @Autowired
    private UserSerice userSerice;

    @Autowired
    private UserDao userDao;

    private DefaultExceptionThrowConfig  defaultExceptionThrowConfig;

    public UserController(UserRepository userRepository, UserDao userDao, final PropertiesConfiguration propertiesConfiguration, final DefaultExceptionThrowConfig defaultExceptionThrowConfig, final UserSerice userSerice) {
        //this.userRepository = userRepository;
        this.userDao = userDao;
        this.propertiesConfiguration=propertiesConfiguration;
        this.defaultExceptionThrowConfig=defaultExceptionThrowConfig;
        this.userSerice=userSerice;
    }

    @RequestMapping(value="/exp",method = RequestMethod.GET)
    public Object getExp() throws AppException{
        if(null!=defaultExceptionThrowConfig.getThrowableCondition() && "true".equalsIgnoreCase(defaultExceptionThrowConfig.getThrowableCondition())){
            throw new AppException("Unknown server exp ocurred");
        }

            return null;

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        logger.info("Getting all users.");
        //return userDao.getAllUsers();
        logger.info("App Name : " + propertiesConfiguration.getName());
        logger.info("Exception throwable : " + defaultExceptionThrowConfig.getThrowableCondition());
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
        userSerice.createUser(user);
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

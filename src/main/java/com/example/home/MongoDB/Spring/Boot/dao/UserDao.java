package com.example.home.MongoDB.Spring.Boot.dao;

import com.example.home.MongoDB.Spring.Boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserById(String userId);
    User addNewUser(User user);
    Object getAllUserSettings(String userId);
    String getUserSetting(String userId, String key);
    String addUserSetting(String userId, String key, String value);

}

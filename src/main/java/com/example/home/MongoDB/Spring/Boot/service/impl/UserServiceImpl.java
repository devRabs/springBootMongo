package com.example.home.MongoDB.Spring.Boot.service.impl;

import com.example.home.MongoDB.Spring.Boot.model.User;
import com.example.home.MongoDB.Spring.Boot.service.UserSerice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSerice {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void createUser(User user) {
        logger.info("UserServie created a new user");
    }
}

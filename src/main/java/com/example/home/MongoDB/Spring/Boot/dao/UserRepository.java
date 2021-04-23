package com.example.home.MongoDB.Spring.Boot.dao;

import com.example.home.MongoDB.Spring.Boot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}

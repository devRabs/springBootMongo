package com.example.home.MongoDB.Spring.Boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbSpringBootApplication.class, args);
	}

}

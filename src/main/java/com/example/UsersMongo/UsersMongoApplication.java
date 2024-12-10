package com.example.UsersMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.UsersMongo.repository")
public class UsersMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersMongoApplication.class, args);
	}

}

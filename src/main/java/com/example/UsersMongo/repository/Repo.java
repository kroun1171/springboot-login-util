package com.example.UsersMongo.repository;

import com.example.UsersMongo.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface Repo extends MongoRepository<Users, String> {
    Users findByEmail(String email);
}

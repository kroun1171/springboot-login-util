package com.example.UsersMongo.controller;
import org.springframework.http.ResponseEntity;

import com.example.UsersMongo.entity.LoginRequest;
import com.example.UsersMongo.entity.Users;
import com.example.UsersMongo.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private Repo repo;

    @GetMapping("/api/all")
    public List<Users>getAllUsers(){
        return repo.findAll();
    }

    @PostMapping("/api/post")
    public Users post(@RequestBody Users user){
        return repo.save(user);
    }

    @GetMapping("/api/{id}")
    public Users getPassengerById(@PathVariable String id){
        return repo.findById(id).orElse(new Users());
    }

    @PostMapping("/api/post-all")
    public List<Users> savePassenger(@RequestBody List<Users> passenger) {
        return repo.saveAll(passenger);
    }


    @DeleteMapping("/api/{id}")
    public void deletePassenger(@PathVariable  String id) {
        repo.deleteById(id);
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Find the user by email
        Users user = repo.findByEmail(loginRequest.getEmail());
    
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // Login success
            return ResponseEntity.ok("Login successful");
        } else {
            // Invalid credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


}

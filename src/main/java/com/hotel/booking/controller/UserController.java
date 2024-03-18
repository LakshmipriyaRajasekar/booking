package com.hotel.booking.controller;

import com.hotel.booking.pojo.User;
import com.hotel.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users")
    public List getUsers(){
        List users = userRepository.findAll();
        return users;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> newUser(@RequestBody User user){
        this.userRepository.add(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user){
        User updateduser = this.userRepository.updateUser(id, user);
        if(updateduser != null){
            return  new ResponseEntity(user, HttpStatus.ACCEPTED);
        }
        System.out.print("");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/users/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        boolean result = this.userRepository.deleteUser(id);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
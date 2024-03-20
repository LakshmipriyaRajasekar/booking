package com.hotel.booking.service;

import com.hotel.booking.exception.UserNotFoundException;
import com.hotel.booking.pojo.User;
import com.hotel.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUserDetails() {
        return new LinkedList<>(userRepository.findAll());
    }

    public User getUserDetailById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User addUserInfo(User user) {
        return userRepository.save(user);
    }
}




package com.hotel.booking.service;

import com.hotel.booking.exception.UserNotFoundException;
import com.hotel.booking.pojo.User;
import com.hotel.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

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

    public User getUserDetailByMailID(String mailId) {
        return userRepository.findByMailId(mailId);
    }

    public User addUserInfo(User user) {
        return userRepository.save(user);
    }

    public User updateUserInfo(User user) {

        User retrievedUser = userRepository.findById(user.getId()).orElseThrow(()->  new UserNotFoundException(user.getId()));
        retrievedUser.setName(user.getName());
        retrievedUser.setMailId(user.getMailId());
        return userRepository.save(retrievedUser);
    }


    public HttpStatus deleteUserInfo(long id) {
        userRepository.findById(id).orElseThrow(()->  new UserNotFoundException(id));
        userRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    public User getUserDetailByName(String name) {
        return userRepository.findByName(name);
    }
}




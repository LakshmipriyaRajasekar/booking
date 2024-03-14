package com.hotel.booking.repository;

import com.hotel.booking.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users;
    UserRepository(){
        this.users = new ArrayList<>();
        users.add(new User(1, "Priya", "abc@gmail.com"));
        users.add(new User(2, "lakshmi","d23@gmail.com"));
        users.add(new User(3, "shruthi","s123@gmail.com"));
    }

    public List<User> findAll(){
        return users;
    }

    public boolean add(User user){
        users.add(user);
        return true;
    }

    public boolean deleteUser(int id){

        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            if(user.getId() == id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public User updateUser(int id, User updatedUser){
        for(int i=0; i<users.size();i++){
            User user = users.get(i);
            if(user.getId() == id){
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }
}

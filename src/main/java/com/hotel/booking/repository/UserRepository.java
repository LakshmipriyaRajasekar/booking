package com.hotel.booking.repository;

import com.hotel.booking.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

    User findByName(String name);
    User findByMailId(String mailId);
}

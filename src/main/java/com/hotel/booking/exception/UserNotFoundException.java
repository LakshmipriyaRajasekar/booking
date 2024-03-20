package com.hotel.booking.exception;

public class UserNotFoundException extends RuntimeException{
    private Long id;

    public UserNotFoundException(Long id){
        super("Given userId is not found "+id);
    }
}

package com.hotel.booking.controller;

import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String args[]){
        List<Integer> input = Arrays.asList(1,6,7,8,9);

   input.stream().map(e->e*3).forEach(System.out::println);


    }
}

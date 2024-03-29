package com.hotel.booking.controller;

import com.hotel.booking.pojo.User;
import com.hotel.booking.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {

    @Autowired
    UserService userService;


    @Operation(summary = "Get the list of Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "users not found",
                    content = @Content) })
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllUsers(
    ){
        List<User> users = userService.getUserDetails();
        if(users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Get the user information by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get user details by id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "users not found",
                    content = @Content) })
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserDetailById(@PathVariable(name="id") long id ){
        return new ResponseEntity<>(userService.getUserDetailById(id), HttpStatus.OK);
    }

    @Operation(summary = "Get the user information by mail address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get user details by mailid",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "users not found",
                    content = @Content) })
    @GetMapping(path = "/mailid/{mailid}")
    public ResponseEntity<?> getUserDetailByMailId(@PathVariable(name="mailid") String mailId ){
        return new ResponseEntity<>(userService.getUserDetailByMailID(mailId), HttpStatus.OK);
    }

    @Operation(summary = "Get the user information by name")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get user details by name",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "404", description = "users not found",
                    content = @Content) })
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<?> getUserDetailByName(@PathVariable(name="name") String name ){
        return new ResponseEntity<>(userService.getUserDetailByName(name), HttpStatus.OK);
    }

    @Operation(summary = "Add/Save the user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Save the user details into DB",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content) })
    @PostMapping(path = "/add")
    public ResponseEntity<?> addUserInfo(@Valid  @RequestBody User user){
        return new ResponseEntity<>(userService.addUserInfo(user), HttpStatus.CREATED);
    }

    @Operation(summary = "Update the user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Save the user details into DB",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content) })
    @PostMapping(path = "/modify")
    public ResponseEntity<?> updateUserInfo(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.updateUserInfo(user), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete the user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Save the user details into DB",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content) })
    @PostMapping(path = "/remove")
    public ResponseEntity<?> deleteUserInfo(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(userService.deleteUserInfo(id), HttpStatus.NO_CONTENT);
    }
}
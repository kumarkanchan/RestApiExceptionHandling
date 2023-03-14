package com.springboot.controller;

import com.springboot.entities.User;
import com.springboot.exceptions.UserDataAccessException;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    //CRUD - Create, Read, Update and Delete

    //@RequestMapping(path = "user/create",method = RequestMethod.POST)
    @PostMapping(path = "user/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        user = userService.createUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(path = "multiUsers/create")
    public void createUsers(@RequestBody Iterable<User> users) {
        userService.createUsers(users);
    }

    @RequestMapping(path = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id) throws UserDataAccessException {
        User user = userService.findUserById(id).orElseThrow(() -> new UserDataAccessException("User not found with ID = " + id));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/allusers")
    public Iterable<User> getAllUsers() {

        return userService.findAllUsers();
    }

    @PutMapping(path = "id/{id}/newAge/{newAge}")
    public void updateUserAgeById(@PathVariable("id") Integer userId, @PathVariable("newAge") Integer newAge) {
        userService.updateUserAgeById(userId, newAge);
    }

    @DeleteMapping(path = "delete/id/{id}")
    public void deleteUserById(@PathVariable("id") Integer userId) {

        userService.deleteUserById(userId);
    }
}
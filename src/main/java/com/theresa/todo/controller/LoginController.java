package com.theresa.todo.controller;

import com.theresa.todo.model.User;
import com.theresa.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAccounts() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getAccount(@PathVariable long id) {
        return null;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public User createAccount(@RequestBody User account) {
        return userService.createUser(account);
    }

    @PutMapping("/{id}")
    public User updateAccount(@PathVariable long id, @RequestBody User account) {
        return account;
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable String email) {
        userService.deleteAccount(email);
    }

    public String createUser(User user){
        return null;
    }
}

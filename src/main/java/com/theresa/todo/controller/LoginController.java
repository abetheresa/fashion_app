package com.theresa.todo.controller;

import com.theresa.todo.model.User;
import com.theresa.todo.model.UserBean;
import com.theresa.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
        "http://localhost:8080",
        "http://54.194.63.172"
})
@RestController
@RequestMapping("/api")
public class LoginController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAccounts() {
        return userService.getUsers();
    }

    @PutMapping("/login")
    public boolean getAccount(@RequestBody UserBean user) {
        User userbean = userService.findByEmail(user.getEmail());
        if(userbean!=null) {
            userbean.getPassword().matches(user.getPassword());
        }
        return true;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User createAccount(@RequestBody UserBean account) {
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

package com.theresa.todo.service;

import com.theresa.todo.model.User;
import com.theresa.todo.model.UserBean;
import com.theresa.todo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    private List<User> users = new ArrayList<>();
    public List<User> getUsers(){
        try {
            users = userRepo.findAll();
        } catch (Exception e) {
            //
        }
        return users;
    }
    public User createUser(UserBean userbean){
        User user = User.builder()
                .name(userbean.getName())
                .email(userbean.getEmail())
                .password(userbean.getPassword())
                .build();
        try {
            userRepo.save(user);
        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public void deleteAccount(String email){
        User user= getUsers().stream().filter(user1 -> user1.getEmail().equalsIgnoreCase(email)).findAny().orElse(null);
        if(null!=user){
            user.setIsDeleted(false);
           userRepo.deleteUser(email);
        }
    }
}

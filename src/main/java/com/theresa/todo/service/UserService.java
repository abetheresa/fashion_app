package com.theresa.todo.service;

import com.theresa.todo.model.User;
import com.theresa.todo.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
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
    public User createUser(User user){
        users.add(user);
        try {
            userRepo.save(user);
        }catch (Exception e){
            //
        }
        return user;
    }
    public void deleteAccount(String email){
        User user= getUsers().stream().filter(user1 -> user1.getEmail().equalsIgnoreCase(email)).findAny().orElse(null);
        if(null!=user){
            user.setIsDeleted(false);
           userRepo.deleteUser(email);
        }
    }
}

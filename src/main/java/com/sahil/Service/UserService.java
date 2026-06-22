package com.sahil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Entity.User;
import com.sahil.Exception.ResourceNotFoundException;
import com.sahil.Repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {

        if(userRepo.existsByEmail(user.getEmail())) {

            throw new RuntimeException(
                    "Email already registered");
        }

        return userRepo.save(user);
    }

    public List<User> getAllUsers() {

        return userRepo.findAll();
    }

    public User getUserById(
            Long id) {

        return userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User Not Found"));
    }

    public User updateUser(
            Long id,
            User user) {

        User existingUser =
                getUserById(id);

        existingUser.setFullName(
                user.getFullName());

        existingUser.setEmail(
                user.getEmail());

        existingUser.setPassword(
                user.getPassword());

        existingUser.setRole(
                user.getRole());

        return userRepo.save(
                existingUser);
    }

    public void deleteUser(
            Long id) {

        User user =
                getUserById(id);

        userRepo.delete(user);
    }
    
    public User loginUser(
            String email,
            String password) {

        User user =
                userRepo.findByEmail(email)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Invalid Email"));

        if (!user.getPassword()
                .equals(password)) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        return user;
    }

}
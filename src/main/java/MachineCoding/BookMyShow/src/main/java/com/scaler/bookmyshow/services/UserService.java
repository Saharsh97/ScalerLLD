package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.UserAlreadyExistsException;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    // 1.1
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // request and response here?
    public User signup(String email, String password) throws UserAlreadyExistsException {
        // 1. validate if the user already exists or not.
        // how to do this? check if email is already there in the table.
        // add findByEmail in the userRepository
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new UserAlreadyExistsException("user already exists!");
        }

        // 2. what if user doesn't exist?
        // create a new user, and put it in the db.
        User user = new User();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setBookings(new ArrayList<>());

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    // 3. login method
    public User login(String email, String password){
        // 1. check if the email is registered.
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new RuntimeException("No user exists with this email");
        }
        User existingUser = userOptional.get();

        // 2. validate password.
        // check if the stored encoded password, matches with the given string.
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!bCryptPasswordEncoder.matches(password, existingUser.getPassword())){
            throw new RuntimeException("Password does not match!");
        }

        return existingUser;
    }
}

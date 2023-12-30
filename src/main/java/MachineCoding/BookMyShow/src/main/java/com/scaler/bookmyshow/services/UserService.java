package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User signup(String email, String userName, String password){
        // 1. validate -> if the user is already in my DB.
        // if the user already exists, that is an exception!
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            System.out.println("user already present");
            throw new RuntimeException("User already Exists!");
        }
        System.out.println("user does not exist in the DB");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        // 2. create the user
        User user = new User();
        user.setName(userName);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setBookings(new ArrayList<>());

        // 3. save the user to the DB.
        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    public User login(String email, String password){
        // 1. validate if user is present or not. if not, exception
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not present in the DB");
        }
        User existingUser = userOptional.get();

        // 2. match the given password, with the encryption stored for the user.
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(!bCryptPasswordEncoder.matches(password, existingUser.getPassword())){
            throw new RuntimeException("Password is incorrect!");
        }

        return existingUser;
    }
}

// Shiva's Password: pass1234 -> 1018973646391ASDF
// Rajat's Password: pass1234 -> 1018973646391ASDF

// password should be encrypted!
// same password, should have different encryptions!!
// the encryption, should not be decodeable!

// BCrypt!


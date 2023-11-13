package com.scaler.bookingmanagement.services;

import com.scaler.bookingmanagement.exceptions.PasswordShortException;
import com.scaler.bookingmanagement.exceptions.UsernameAlreadyPresentException;
import com.scaler.bookingmanagement.models.User;
import com.scaler.bookingmanagement.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User create(String username, String password) {
        //validate username
        // validate user password
        validate(username, password);
        User user = new User(username, password);
        return userRepository.save(user);
    }

    private void validate(String username, String password) {
        Optional<User> existingUser = userRepository.getUserByUserName(username);
        if(existingUser.isPresent()) {
            throw new UsernameAlreadyPresentException(username);
        }
        if(password.length() < 8) {
            throw new PasswordShortException();
        }
    }
}

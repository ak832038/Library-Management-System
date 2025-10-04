package org.gfg.Library_Management_Minor.service;

import jakarta.validation.Valid;
import org.gfg.Library_Management_Minor.dto.UserRequest;
import org.gfg.Library_Management_Minor.model.User;
import org.gfg.Library_Management_Minor.model.UserType;
import org.gfg.Library_Management_Minor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addStudent(@Valid UserRequest userRequest) {

        User user=userRequest.toUser();
        user.setUserType(UserType.valueOf("STUDENT"));
        return userRepository.save(user);
    }

    public User addAdmin(@Valid UserRequest userRequest) {
        User user=userRequest.toUser();
        user.setUserType(UserType.valueOf("ADMIN"));
        return userRepository.save(user);
    }
}

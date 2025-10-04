package org.gfg.Library_Management_Minor.controller;

import jakarta.validation.Valid;
import org.gfg.Library_Management_Minor.dto.UserRequest;
import org.gfg.Library_Management_Minor.model.User;
import org.gfg.Library_Management_Minor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addStudent")
    public User addStudentToDB(@RequestBody @Valid UserRequest userRequest) {
        //validations before business logic

        //call business logic
       return userService.addStudent(userRequest);
    }

    @PostMapping("/addAdmin")
    public User addAdminToDB(@RequestBody @Valid UserRequest userRequest) {
        //validations before business logic

        //call business logic
        return userService.addAdmin(userRequest);
    }
}

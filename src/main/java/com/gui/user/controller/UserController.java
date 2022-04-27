package com.gui.user.controller;

import com.gui.user.VO.ResponseTemplateVO;
import com.gui.user.model.User;
import com.gui.user.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public User getUser(@PathVariable Long id) {
//
//        return userService.getUser(id);
//    }

    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long userId) {

        return userService.getUserWithDepartment(userId);
    }
}

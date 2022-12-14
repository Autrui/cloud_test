package com.dwg.controller;

import com.dwg.entity.User;
import com.dwg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Autrui
 * @since 2022-12-07
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable String userId) {
        return userService.getById(userId);
    }
}

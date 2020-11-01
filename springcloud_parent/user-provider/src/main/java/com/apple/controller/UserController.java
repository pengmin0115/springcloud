package com.apple.controller;

import com.apple.pojo.User;
import com.apple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengmin
 * @date 2020/10/29 17:29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable(name = "id") Integer id) {
       /* try {
            System.out.println("user-provider...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("user-provider1...");
        return userService.findByUserId(id);
    }
}

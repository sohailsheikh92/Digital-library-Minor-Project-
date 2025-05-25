package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService uservice;

    @PostMapping("/addData")
    public User addData(@RequestBody User user){
        return uservice.addData(user);
    }

    @GetMapping("/getData")
    public List<User> getData(){
        return uservice.getData();
    }
}

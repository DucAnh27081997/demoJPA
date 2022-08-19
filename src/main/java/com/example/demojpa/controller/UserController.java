package com.example.demojpa.controller;

import com.example.demojpa.entity.User;
import com.example.demojpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/AddAll/{x}")
    public String addAll(@PathVariable int x) {
        userService.addAll(x);
        return "add OK!";
    }

    @GetMapping(value = "/AddAll2/{x}")
    public String addAll2(@PathVariable int x) {
        userService.addAll2(x);
        return "add 2 OK!";
    }

    @GetMapping(value = "/showForTable/{x}")
    public String showForTable(@PathVariable int x) {
        return "showForTable  OK!";
    }

}

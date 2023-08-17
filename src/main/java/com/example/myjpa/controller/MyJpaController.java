package com.example.myjpa.controller;

import com.example.myjpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class MyJpaController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/hello")
    public String getUsers(){
        return "hello";
    }
}

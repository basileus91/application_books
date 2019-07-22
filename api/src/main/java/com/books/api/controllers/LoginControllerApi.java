package com.books.api.controllers;

import com.books.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllerApi {

    @Autowired
    private UserService userService;

}

package com.springbt.spamanagement.controller;

import com.springbt.spamanagement.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }
}
//booking:
//date
//experts dropdown
//availa slots dropdown

//booking status form:aproove or not (booking id)

//when user login successfull then link redirected to the user page
//when admin login successfull then link redirected to the admin page
//user page has options Book slot and Booking status
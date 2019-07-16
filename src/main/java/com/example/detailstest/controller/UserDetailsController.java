package com.example.detailstest.controller;


import com.example.detailstest.model.UserDetails;
import com.example.detailstest.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/details/{name}")
    private UserDetails getDetails(@PathVariable String name) {
        return userDetailsService.getUserDetails(name);
    }

    @DeleteMapping("/details/{name}")
    private String deleteDetails(@PathVariable String name) {
        return userDetailsService.deleteUserDetails(name);
    }

    @PostMapping("/details")
    private String createUser(@RequestBody  UserDetails userDetails) {
        return userDetailsService.createUser(userDetails);
    }

    @PutMapping("/details/{name}")
    private String updateUser(@RequestBody UserDetails userDetails, @PathVariable String name) {
        return userDetailsService.updateDetails((userDetails));
    }

}

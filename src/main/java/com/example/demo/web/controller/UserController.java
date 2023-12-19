package com.example.demo.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.register(user);
        return "redirect:/login";
    }

    @PostMapping("/customer/logon.html")
    @ResponseBody // return JSON response instead of view name
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK); // return 200 OK status
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED); // return 401 Unauthorized status
        }
    }
    @GetMapping("/view1.html")
    public String view1() {
        return "view1"; // return the view1.html template
    }
}

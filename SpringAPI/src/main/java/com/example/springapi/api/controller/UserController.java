package com.example.springapi.api.controller;

import com.example.springapi.api.model.IsOddResponse;
import com.example.springapi.api.model.User;
import com.example.springapi.service.OddService;
import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;
    private OddService oddService;

    @Autowired
    public UserController(UserService userService, OddService oddService){
        this.userService=userService;
        this.oddService=oddService;
    }

    @GetMapping("/api/get-user/{id}")
    public User getUser(@PathVariable Integer id){
        Optional user = userService.getUser(id);
        if(user.isPresent()) return (User) user.get();
        return null;
    }

    @GetMapping("/api/is-odd/{number}")
    public IsOddResponse isOdd(@PathVariable String number){
        System.out.println(number);
        Integer x;
        try{
            x = Integer.valueOf(number);
            Optional response = oddService.getResponse(x);
            if(response.isPresent()) return (IsOddResponse) response.get();
        }catch(Exception ignored){
            System.out.println(ignored.toString());
        }
        return null;
    }

}

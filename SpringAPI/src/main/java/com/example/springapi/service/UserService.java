package com.example.springapi.service;

import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user = new User(1,"name",20,"example@email.com");
        User user1 = new User(2,"surname",18,"mrkrabs@yahoo.com");
        User user2 = new User(3,"old",97,"bigzucc@facebook.com");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for(User x:userList){
            if(x.getId() == id) {
                optional = Optional.of(x);
            }
        }
        return optional;
    }
}

package com.example.springapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {
    @Setter
    private int id;
    @Setter
    private String name;
    @Setter
    private int age;
    @Setter
    private String email;

}
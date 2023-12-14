package com.example;

import com.annotations.NotBlank;
import com.annotations.Positive;

public class User {
     @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Positive
    private int age;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
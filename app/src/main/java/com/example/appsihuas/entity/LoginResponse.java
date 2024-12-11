package com.example.appsihuas.entity;
public class LoginResponse {
    private String token;
    private User user;
    private String message;

    // Getters
    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}


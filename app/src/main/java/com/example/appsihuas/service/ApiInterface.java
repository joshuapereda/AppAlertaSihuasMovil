package com.example.appsihuas.service;

import com.example.appsihuas.entity.LoginRequest;
import com.example.appsihuas.entity.LoginResponse;
import com.example.appsihuas.entity.RegisterRequest;
import com.example.appsihuas.entity.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("login") // Endpoint de tu API
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("register")
    Call<UserResponse> registerUser(@Body RegisterRequest registerRequest);
}

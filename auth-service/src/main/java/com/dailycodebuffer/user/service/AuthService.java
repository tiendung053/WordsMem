package com.dailycodebuffer.user.service;


import model.LoginResponseDTO;

import java.security.NoSuchAlgorithmException;

public interface AuthService {
    LoginResponseDTO login(String username, String password) throws NoSuchAlgorithmException;
}

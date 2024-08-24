package com.dailycodebuffer.user.service;


import exception.CustomException;
import model.AccountDTO;
import model.LoginResponseDTO;

import java.security.NoSuchAlgorithmException;

public interface AuthService {
    LoginResponseDTO login(AccountDTO accountDTO) throws NoSuchAlgorithmException, CustomException;
}

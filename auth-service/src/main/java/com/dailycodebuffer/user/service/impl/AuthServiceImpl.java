package com.dailycodebuffer.user.service.impl;

import com.dailycodebuffer.user.service.AuthService;
import com.dailycodebuffer.user.service.CoreClientService;
import config.JwtTokenProvider;
import model.AccountDTO;
import model.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultil.Base64Ultils;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CoreClientService coreClientService;


    @Override
    public LoginResponseDTO login(String username, String password) {
        AccountDTO accountDTO = coreClientService
                .getAccountByUsernameAndPassword(
                        Base64Ultils.decodeBase64ToString(username),
                        Base64Ultils.decodeBase64ToString(password));
        String jwt = JwtTokenProvider.generateToken(accountDTO.getUsername());
        return new LoginResponseDTO(jwt);
    }

}

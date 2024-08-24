package com.dailycodebuffer.user.service.impl;

import com.dailycodebuffer.user.service.AuthService;
import com.dailycodebuffer.user.service.CoreClientService;
import com.dailycodebuffer.user.service.RedisService;
import config.JwtTokenProvider;
import exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import model.AccountDTO;
import model.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ultil.Base64Ultils;


@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CoreClientService coreClientService;

    @Autowired
    private RedisService redisService;

    @Override
    public LoginResponseDTO login(AccountDTO accountDTOs) throws CustomException {
        AccountDTO accountDTO = coreClientService
                .getAccountByUsernameAndPassword(
                        Base64Ultils.decodeBase64ToString(accountDTOs.getUsername()),
                        Base64Ultils.decodeBase64ToString(accountDTOs.getPassword()));
        String jwt = JwtTokenProvider.generateToken(accountDTO.getUsername());
        redisService.set("Session",jwt,accountDTO,3000);
        return new LoginResponseDTO(jwt);
    }

}

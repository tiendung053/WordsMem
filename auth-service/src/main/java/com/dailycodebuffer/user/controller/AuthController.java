package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.service.AuthService;
import com.dailycodebuffer.user.service.RedisService;
import exception.CustomException;
import model.AccountDTO;
import model.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private RedisService redisService;

    @PostMapping(value = "login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody AccountDTO accountDTO) throws NoSuchAlgorithmException, CustomException {
        return new ResponseEntity<>(authService.login(accountDTO), HttpStatus.OK);
    }

    @GetMapping(value = "info")
    public ResponseEntity<AccountDTO> info(ServerHttpRequest request) {
        String token = request.getHeaders().getOrEmpty("Authorization").get(0);
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            token.substring(7);
        }
        AccountDTO accountDTO = (AccountDTO) redisService.get("Session",token);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}

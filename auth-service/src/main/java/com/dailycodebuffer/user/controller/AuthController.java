package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.service.AuthService;
import model.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<LoginResponseDTO> login(@RequestParam("username") String username,
                                                  @RequestParam("password") String password) throws NoSuchAlgorithmException {
        return new ResponseEntity<>(authService.login(username, password), HttpStatus.OK);
    }

    @GetMapping(value = "info")
    public String getInfo() {
        return "Ngu di anh";
    }
}

package com.coreservice.controller;

import com.coreservice.entity.Account;
import com.coreservice.repository.AccountRepository;
import com.coreservice.service.UserService;
import exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import model.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@Valid
@RequestMapping("/user")
public class AccountController extends GenericController<Account> {

    public AccountController(AccountRepository accountRepository) {
        super(accountRepository);
    }

    @Autowired
    private UserService userService;

    @GetMapping("get-username-password")
    public ResponseEntity<AccountDTO> getAccountByUsernameAndPassword(
            @RequestParam String username,
            @RequestParam String password) throws CustomException {
        return new ResponseEntity<>(userService.getAccountByUsernameAndPassword(username, password), HttpStatus.OK);
    }
}

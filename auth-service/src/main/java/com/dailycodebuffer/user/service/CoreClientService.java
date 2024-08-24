package com.dailycodebuffer.user.service;

import exception.CustomException;
import model.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giveYourServiceName", url = "http://localhost:10701", path = "core")
public interface CoreClientService {
    @GetMapping("user/get-username-password")
    public AccountDTO getAccountByUsernameAndPassword(@RequestParam String username,
                                                      @RequestParam String password) throws CustomException;
}

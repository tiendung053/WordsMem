package com.coreservice.service;

import com.coreservice.entity.Account;
import com.coreservice.repository.AccountRepository;
import model.AccountDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountRepository accountRepository;

    public AccountDTO getAccountByUsernameAndPassword(String username, String password) {
        Account account = accountRepository.findByUsernameAndPassword(username,password);
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        return accountDTO;
    }
}

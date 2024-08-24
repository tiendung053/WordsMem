package com.coreservice.service;

import com.coreservice.entity.Account;
import com.coreservice.repository.AccountRepository;
import exception.CustomException;
import lombok.SneakyThrows;
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

    public AccountDTO getAccountByUsernameAndPassword(String username, String password) throws CustomException {
        if (!accountRepository.existsAccountByUsername(username)) {
            throw new CustomException(401,"Không tìm thấy tên đăng nhập");
        }
        if (!accountRepository.existsAccountByPassword(password)) {
            throw new CustomException(402,"Mật khẩu không chính xác");
        }
        Account account = accountRepository.findByUsernameAndPassword(username,password);
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        return accountDTO;
    }
}

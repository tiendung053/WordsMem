//package com.dailycodebuffer.cloud.gateway.service;
//
//import com.dailycodebuffer.cloud.gateway.CustomUserDetails;
//import com.dailycodebuffer.cloud.gateway.client.CoreClientService;
//import model.AccountDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements UserDetailsService {
//    @Autowired
//    private CoreClientService coreClientService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        // Kiểm tra xem user có tồn tại trong database không?
//        AccountDTO accountDTO = coreClientService.getAccountByUserId(Long.valueOf(username));
//        if (accountDTO == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new CustomUserDetails(accountDTO);
//    }
//}

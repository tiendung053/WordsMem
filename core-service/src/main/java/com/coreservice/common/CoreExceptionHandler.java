package com.coreservice.common;

import exception.CustomException;
import model.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class CoreExceptionHandler {

    @ExceptionHandler({ CustomException.class })
    public ResponseEntity<ResponseDTO> handleExceptionA(Exception e) {
        return ResponseEntity.status(432).body(new ResponseDTO(System.currentTimeMillis(),new Date(), e.getMessage(), ""));
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<ResponseDTO> handleExceptionRuntime(Exception e) {
        return ResponseEntity.status(404).body(new ResponseDTO(System.currentTimeMillis(),new Date(),"Lỗi không xác định", ""));
    }

}

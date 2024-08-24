package com.dailycodebuffer.user.common;

import exception.CustomException;
import model.ResponseDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ultil.ExceptionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AuthenExceptionHandler {

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<ResponseDTO> handleExceptionRuntime(Exception e) throws JSONException {
        int jsonStart = e.getMessage().indexOf("{");
        int jsonEnd = e.getMessage().lastIndexOf("}") + 1;
        String jsonString = e.getMessage().substring(jsonStart, jsonEnd);
        JSONObject jsonObject = new JSONObject(jsonString);
        String message = jsonObject.getString("message");
        return ResponseEntity.status(404).body(new ResponseDTO(System.currentTimeMillis(),new Date(),message, ""));
    }

    @ExceptionHandler({ CustomException.class })
    public ResponseEntity<ResponseDTO> handleExceptionCustomException(Exception e) {
        return ResponseEntity.status(404).body(new ResponseDTO(System.currentTimeMillis(),new Date(),e.getMessage(), ""));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ResponseDTO> handleValidationExceptionsUsername(
            MethodArgumentNotValidException e) {
        Map<String, String> errors = ExceptionUtils.getErrors(e);
       return ResponseEntity.status(404).body(new ResponseDTO(System.currentTimeMillis(),new Date(),errors.toString(), ""));
    }
}

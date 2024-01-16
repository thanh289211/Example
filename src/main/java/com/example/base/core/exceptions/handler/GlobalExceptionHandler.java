package com.example.base.core.exceptions.handler;

import com.example.base.business.response.BaseResponse;
import com.example.base.core.exceptions.SystemException;
import com.example.base.helpers.enums.ResponseStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SystemException.class)
    protected ResponseEntity<BaseResponse> handleSystemException(SystemException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(BaseResponse.error(ResponseStatus.SYSTEM_ERROR, ex.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse> handle(Exception ex,
                                               HttpServletRequest request, HttpServletResponse response) {
        ex.printStackTrace();
        return new ResponseEntity<>(BaseResponse.error(ResponseStatus.SYSTEM_ERROR, "Lỗi hệ thống"), HttpStatus.OK);
    }
}


package com.example.base.controllers;

import com.example.base.request.PageRequest;
import com.example.base.response.BaseResponse;
import com.example.base.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("getAll")
    public ResponseEntity<?> listAll (@RequestBody PageRequest pageRequest){
        return new ResponseEntity<>(BaseResponse.success(userService.listAllByPage(pageRequest)), HttpStatus.OK);
    }
}

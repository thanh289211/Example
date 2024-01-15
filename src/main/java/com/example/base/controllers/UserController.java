package com.example.base.controllers;

import com.example.base.request.PageRequest;
import com.example.base.request.SearchUserRequest;
import com.example.base.request.UserRequest;
import com.example.base.response.BaseResponse;
import com.example.base.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("getAll")
    public ResponseEntity<?> listAll (@RequestBody PageRequest pageRequest){
        return new ResponseEntity<>(BaseResponse.success(userService.listAllByPage(pageRequest)), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<?> search(@RequestBody SearchUserRequest searchUserRequest){
        return new ResponseEntity<>(BaseResponse.success(userService.search(searchUserRequest)), HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<?> insert(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(BaseResponse.success(userService.insert(userRequest)), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody UserRequest userRequest, @RequestParam long id){
        return new ResponseEntity<>(BaseResponse.success(userService.update(userRequest, id)), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam long id){
        userService.delete(id);
        return new ResponseEntity<>(BaseResponse.success(""),HttpStatus.OK);
    }
}

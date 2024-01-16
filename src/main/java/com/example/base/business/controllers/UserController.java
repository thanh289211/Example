package com.example.base.business.controllers;

import com.example.base.business.request.PageRequest;
import com.example.base.business.request.SearchUserRequest;
import com.example.base.business.request.UserRequest;
import com.example.base.business.response.BaseResponse;
import com.example.base.business.services.UserService;
import com.example.base.core.configurations.ResourcePath;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(ResourcePath.BASE + "/user")
public class UserController {
    private final UserService userService;

    @PostMapping("getAll")
    public ResponseEntity<?> listAll (@RequestBody PageRequest pageRequest){
        return new ResponseEntity<>(BaseResponse.success(userService.listAllByPage(pageRequest)), HttpStatus.OK);
    }

    @PostMapping("search")
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

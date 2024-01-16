package com.example.base.business.services;

import com.example.base.business.entities.UserEntity;
import com.example.base.business.repositories.UserRepository;
import com.example.base.business.request.PageRequest;
import com.example.base.business.request.SearchUserRequest;
import com.example.base.business.request.UserRequest;
import com.example.base.business.response.UserResponse;
import com.example.base.core.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    public Page<UserResponse> listAllByPage(PageRequest request){
        org.springframework.data.domain.PageRequest pageable = org.springframework.data.domain.PageRequest.of(request.getPageNumber() - 1, request.getPageSize(), Sort.by("id"));
        Page<UserEntity> list = userRepository.findAll(pageable);
        List<UserResponse> results = list.stream().map(UserResponse::of)
                .collect(Collectors.toList());
        return new PageImpl<>(results, pageable, list.getTotalElements());
    }

    public Page<UserResponse> search(SearchUserRequest request){
        org.springframework.data.domain.PageRequest pageable = org.springframework.data.domain.PageRequest.of(request.getPageNumber(), request.getPageSize(), Sort.by("id"));
        Page<UserEntity> list = userRepository.search(request.getValue(), pageable);
        List<UserResponse> results = list.stream().map(UserResponse::of)
                .collect(Collectors.toList());
        return new PageImpl<>(results, pageable, list.getTotalElements());
    }

    public UserResponse insert(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setAddress(userRequest.getAddress());
        userRepository.save(userEntity);
        return UserResponse.of(userEntity);
    }

    public UserResponse update(UserRequest userRequest, long id){
        UserEntity userEntity = findUserById(id);
        userEntity.setName(userRequest.getName());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setAddress(userRequest.getAddress());
        userRepository.save(userEntity);
        return UserResponse.of(userEntity);
    }

    public void delete(long id){
        UserEntity userEntity = findUserById(id);
        userRepository.delete(userEntity);
    }

    public UserEntity findUserById(long id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found"));
    }
}

package com.example.base.services;

import com.example.base.entities.UserEntity;
import com.example.base.repositories.UserRepository;
import com.example.base.request.PageRequest;
import com.example.base.request.SearchUserRequest;
import com.example.base.request.UserRequest;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    public Page<UserEntity> listAllByPage(PageRequest request){
        org.springframework.data.domain.PageRequest pageable = org.springframework.data.domain.PageRequest.of(request.getPageNumber() - 1, request.getPageSize());
        Page<UserEntity> list = userRepository.findAll(pageable);
        List<UserEntity> results = list.stream().map(entity ->
                new UserEntity(entity.getId(), entity.getName(), entity.getPhoneNumber(), entity.getAddress()))
                .collect(Collectors.toList());
        return new PageImpl<>(results, pageable, list.getTotalElements());
    }

    public Page<UserEntity> search(SearchUserRequest request){
        org.springframework.data.domain.PageRequest pageable = org.springframework.data.domain.PageRequest.of(request.getPageNumber(), request.getPageSize());
        Page<UserEntity> list = userRepository.search(request.getValue(), pageable);
        List<UserEntity> results = list.stream().map(entity ->
                        new UserEntity(entity.getId(), entity.getName(), entity.getPhoneNumber(), entity.getAddress()))
                .collect(Collectors.toList());
        return new PageImpl<>(results, pageable, list.getTotalElements());
    }

    public UserEntity insert(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userEntity.getName());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setAddress(userRequest.getAddress());
        userRepository.save(userEntity);
        return userEntity;
    }

    public UserEntity update(UserRequest userRequest, long id){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(userEntity.getName());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setAddress(userRequest.getAddress());
        userRepository.save(userEntity);
        return userEntity;
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }
}

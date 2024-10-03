package com.assignment.seminar3.user.Service;


import com.assignment.seminar3.user.Dto.UserDto;
import com.assignment.seminar3.user.Entity.User;
import com.assignment.seminar3.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDto userDto) {
            User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
        userRepository.save(user); //save자동으로 있음

    }

    public UserDto read(long userId){
        User user = userRepository.findById(userId).get();
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public List<UserDto> readAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user ->
                UserDto.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build()).toList();
        return userDtos;
    }

    //저
    public void update(long userId, UserDto userDto) {
        User user = userRepository.findById(userId).get();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user); //업데이트한걸 세이브?
    }

    public void delete(long userId) {
        userRepository.deleteById(userId);
    }


    public Long getUserNum(String email) {
        User user = userRepository.findByEmail(email);
        return user.getId();
    }

}

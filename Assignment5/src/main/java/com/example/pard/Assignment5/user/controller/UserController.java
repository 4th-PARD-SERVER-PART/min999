package com.example.pard.Assignment5.user.controller;

import com.example.pard.Assignment5.user.dto.UserReqDto;
import com.example.pard.Assignment5.user.dto.UserResDto;
import com.example.pard.Assignment5.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public void createUser(@RequestBody UserReqDto.UserCreateReqDto req){
        userService.save(req); //객체 저장
    }

    @GetMapping("/{userId}")
    public UserResDto.UserReadResDto readUser(@PathVariable Long userId){
        return userService.read(userId);
    }

    @GetMapping("/like/{userId}")
    public UserResDto.UserReadLikeUserDto readLikeUser(@PathVariable Long userId){
        return userService.readLikeUser(userId);
    }

    @PatchMapping("/{userId}")
    public UserResDto.UserReadResDto update(@PathVariable Long userId,
                                            @RequestBody UserReqDto.UserCreateReqDto req ){
        return userService.update(userId,req);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }
}

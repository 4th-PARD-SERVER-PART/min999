package com.assignment.seminar3.user.controller;

import com.assignment.seminar3.user.Dto.UserDto;
import com.assignment.seminar3.user.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto readById(@PathVariable long userId) {
        return userService.read(userId);
    }

    @GetMapping("")
    public List<UserDto> readAll() {
        return userService.readAll();
    }

    @PatchMapping("/{userId}")
    public void update(@PathVariable long userId, @RequestBody UserDto userDto) {
        userService.update(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable long userId) {
        userService.delete(userId);
    }

        @GetMapping("/userNum")
        public ResponseEntity<Long> readByEmail(@RequestParam String email) {
            Long responseValue = userService.getUserNum((email));
            return new ResponseEntity<>(responseValue, HttpStatus.OK);
        }


}

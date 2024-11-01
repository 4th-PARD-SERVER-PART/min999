package com.example.pard.Assignment5.like.controller;


import com.example.pard.Assignment5.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")

public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{userId}/{postId}")
    public void save(@PathVariable Long userId, @PathVariable Long postId) {
        likeService.save(userId,postId);
    }
    //유저아이디/포스트아이디 -> 좋아요


}

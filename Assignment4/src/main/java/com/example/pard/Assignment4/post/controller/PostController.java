package com.example.pard.Assignment4.post.controller;

import com.example.pard.Assignment4.post.dto.PostReqDto;
import com.example.pard.Assignment4.post.dto.PostResDto;
import com.example.pard.Assignment4.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/{userId}")
    public void create(@PathVariable Long userId,
            @RequestBody PostReqDto.PostCreateReqDto req){
        postService.create(userId, req);
    } //유저아이디로 포스트 쓰기

    @GetMapping("/{postId}")
    public PostResDto.PostReadResDto read(@PathVariable Long postId){
        return postService.read(postId);
    } //포스트 아이디로 내가 쓴 글 불러오기

    @GetMapping("/like/{postId}")
    public PostResDto.PostLikeResDto readUser(@PathVariable Long postId){
        return postService.readUser(postId);
    } //포스트아이디로 좋아요누른 유저들 보기


}

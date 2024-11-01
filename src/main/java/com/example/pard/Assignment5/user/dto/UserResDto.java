package com.example.pard.Assignment5.user.dto;

import com.example.pard.Assignment5.like.dto.LikeResDto;
import com.example.pard.Assignment5.post.dto.PostResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;



public class UserResDto {

    @Getter
    @AllArgsConstructor @NoArgsConstructor
    @Builder

    public static class UserReadResDto{
        private String name;
        private String num;
        private List<PostResDto.PostReadResDto> posts;
    } //포스트 읽어서 넘겨주기

    @Getter
    @AllArgsConstructor @NoArgsConstructor
    @Builder
    public static class UserReadLikeUserDto{
        private String name;
        private String num;
        private List<LikeResDto.LikeResPostDto> posts;
    } //내가 누른 포스트들 보여주기

}

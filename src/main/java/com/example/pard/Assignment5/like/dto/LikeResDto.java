package com.example.pard.Assignment5.like.dto;

import com.example.pard.Assignment5.like.entity.Good;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public class LikeResDto {

    @Getter
    @AllArgsConstructor @NoArgsConstructor
    @Builder
    public static class LikeResUserDto {
        private String name;

        public static List<LikeResUserDto> LikeUser(List<Good> goods) {
            return goods.stream().map(good ->
                    LikeResUserDto.builder()
                            .name(good.getUser().getName())
                            .build()).toList();
            //포스트 아이디 받아서
            //좋아요 누른 유저 리스트 뽑아서 넘겨주기
        }
    }
    @Getter
    @AllArgsConstructor @NoArgsConstructor
    @Builder
    public static class LikeResPostDto{
        private String title;
        private String text;

        public static List<LikeResPostDto> LikePost(List<Good> goods){
            return goods.stream().map(good ->LikeResPostDto.builder()
                    .title(good.getPost().getTitle())
                    .text(good.getPost().getText())
                    .build()).toList();
        }
    }
    //유저아이디 받아서
    //좋아요 누른 포스트들 보여주기




}

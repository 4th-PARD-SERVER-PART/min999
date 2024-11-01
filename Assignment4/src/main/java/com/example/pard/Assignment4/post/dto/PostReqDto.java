package com.example.pard.Assignment4.post.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class PostReqDto {

    @Getter
    @AllArgsConstructor @NoArgsConstructor
    @Builder
    public static class PostCreateReqDto{
        private String title;
        private String text;
    }


}

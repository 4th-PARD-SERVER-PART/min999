package com.practice.teacher.dto;

import com.practice.post.dto.PostRes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

public class TeacherRes {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadPostDto{
        private String name;
        private List<PostRes.PostReadResDto> posts;
    } //포스트 읽어서 넘겨주기

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadDto{
        private String name;
        private String text;
    } //포스트 읽어서 넘겨주기


}

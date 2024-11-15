package com.practice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import com.practice.post.dto.PostRes;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class UserRes {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserUpdateDto{
        private String name;
        private String phone;
    }


    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserReadDto{
        private String name;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserReadPostDto{
        private String name;
        private List<PostRes.PostReadResDto> posts;
    } //포스트 읽어서 넘겨주기


}

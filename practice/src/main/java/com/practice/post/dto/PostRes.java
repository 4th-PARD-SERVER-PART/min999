package com.practice.post.dto;





import com.practice.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class PostRes {

    @Getter
    @AllArgsConstructor @NoArgsConstructor
    @Builder
    public static class PostReadResDto{
        private String title;
        private String text;

        public static List<PostReadResDto> postToDto (List<Post > posts){
            return posts.stream().map(post ->
                    PostReadResDto.builder()
                            .text(post.getText())
                            .build()) .toList();
        }
        //posts 객체리스트들을 받아
        //dto리스트로 바꾸기
    }



}
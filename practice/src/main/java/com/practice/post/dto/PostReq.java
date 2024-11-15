package com.practice.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostReq {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Schema
    public static class CreateDto {

        @Schema(description = "게시글제목", example = "제목입니다")
        @NotNull
        @NotEmpty
        private String title;

        @Schema(description = "글 내용", example = "글 전문")
        @NotNull
        @NotEmpty
        private String text;
    }

}

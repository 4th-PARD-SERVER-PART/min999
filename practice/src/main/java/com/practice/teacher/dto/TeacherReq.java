package com.practice.teacher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TeacherReq {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Schema
    public static class CreateDto {

        @Schema(description = "유저이름", example = "사용자123")
        @NotNull
        @NotEmpty
        private String name;

    }


}

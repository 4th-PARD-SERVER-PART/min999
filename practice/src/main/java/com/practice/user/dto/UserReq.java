package com.practice.user.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import com.practice.user.entity.User;

public class UserReq {

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

        @Schema(description = "유저번호", example = "01012345678")
        @NotNull
        @NotEmpty
        private String phone;
    }




}
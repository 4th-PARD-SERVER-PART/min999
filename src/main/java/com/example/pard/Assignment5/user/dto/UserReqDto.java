package com.example.pard.Assignment5.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserReqDto {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @AllArgsConstructor
    @NoArgsConstructor

    public static class UserCreateReqDto {
        private String name;
        private String num;
    }




}

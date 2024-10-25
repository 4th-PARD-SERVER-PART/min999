package com.example.seminar4.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



public class BookRequest {
    @Getter
    @Builder
    @AllArgsConstructor @NoArgsConstructor


    public static class BookCreateRequest {
        private String title; //객체를 만들지 않고도 객체를 돌려줄 수 있다.
    } //단일 책임 원칙 내부 클래스 , bookrequset와 관련된 모든 클래스



}

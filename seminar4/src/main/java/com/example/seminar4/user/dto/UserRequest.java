package com.example.seminar4.user.dto;

import com.example.seminar4.book.entity.Book;
import com.example.seminar4.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserRequest {

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)  //없으면 알아서 처리해주라
    @AllArgsConstructor @NoArgsConstructor
    public static class UserCreateRequest { //내가 서버에 저장할떄
        //create dto를 통해 서버로 저장함
        private String name;
        private List<Book> book; //북은 있을 수도 있고 없을 수도 있다.

        //그래서 이걸 처리 해줌
    }
}

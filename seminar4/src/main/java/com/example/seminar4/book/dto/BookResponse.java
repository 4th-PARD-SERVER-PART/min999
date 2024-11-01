package com.example.seminar4.book.dto;

import com.example.seminar4.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder //static과 builder가 있으면 객체를 만들 수 있다 setter없이
    public static class BookReadResponse {
        private long bookId;
        private String title;

        public static List<BookReadResponse> bookToDto(List<Book> books) {
            List<BookReadResponse> ret = new ArrayList<>();
            for (Book book : books) {
                BookReadResponse b =
                        new BookReadResponse(book.getId(), book.getTitle());
                ret.add(b);
            }
            return ret;
            //스트림,맵이랑 똑같다. 그걸로 해오됨
        }
    }
}

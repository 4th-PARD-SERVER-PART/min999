package com.example.seminar4.book.entity;


import com.example.seminar4.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //user_id라는 참조필드를 만들어서 user라는entity와 연결해라


    public static Book from(String title, User user){
        return new Book(null, title, user);
    }//타이틀, 유저정보를 받아서 객체를 만들어야함
    //빌더 안쓰고

}
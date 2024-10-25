package com.example.seminar4.user.entity;


import com.example.seminar4.book.entity.Book;
import com.example.seminar4.card.entity.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //저장, 병합, 삭제 관계만 자른다
    //orphan 지워준다.
    //orphan
    private List<Book> book;



    @OneToOne(mappedBy = "user")
    private Card card;

    public void assignCard(Card card) {
        this.card = card;
    }
}



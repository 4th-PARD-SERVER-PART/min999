package com.example.pard.Assignment4.post.entity;


import com.example.pard.Assignment4.like.entity.Good;
import com.example.pard.Assignment4.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Good> goods;

    public void updateTitle(String newTitle) {
        this.title = newTitle;
    }

    public void updateText(String newText) {
        this.text = newText;
    }

}

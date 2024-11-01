package com.example.seminar4.card.entity;


import com.example.seminar4.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.IdentifierLoadAccess;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    //이렇게 카드에 유저에대한 정보넣음
    public void assignUser(User user) {
        this.user = user;
        user.assignCard(this);

    }

}

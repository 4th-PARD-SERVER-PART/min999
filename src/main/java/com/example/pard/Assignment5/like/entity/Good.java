package com.example.pard.Assignment5.like.entity;

import com.example.pard.Assignment5.post.entity.Post;
import com.example.pard.Assignment5.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Good {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private boolean isLike;

@ManyToOne
@JoinColumn(name = "post_id")
private Post post;


@ManyToOne
@JoinColumn(name = "user_id")
private User user;

}

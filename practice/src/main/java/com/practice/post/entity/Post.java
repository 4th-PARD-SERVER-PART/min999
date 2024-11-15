package com.practice.post.entity;

import com.practice.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.practice.user.entity.User;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String text;
    //private String imagePath;


    @ManyToOne
    @JoinColumn(name = "user_id") //게시글에 user_id 컬럼 추가 fk
    private User user;

    @ManyToOne
    @JoinColumn(name = "teacher_id") // FK: Teacher와 연결
    private Teacher teacher;




    public void updateText(String newText){
        this.text = newText;
    }

}

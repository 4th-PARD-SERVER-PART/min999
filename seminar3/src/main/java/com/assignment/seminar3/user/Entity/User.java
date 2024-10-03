package com.assignment.seminar3.user.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Timestamp createdAt;

    public User(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}

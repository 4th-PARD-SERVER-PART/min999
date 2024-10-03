package com.assignment.assignment3.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
@id
@GeneratedValue
*/
public class Menu {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuid;


    @Column(name = "bname", nullable = false, length = 20)
    private String bname;

    @Column(name = "price", nullable = false, length = 20)
    private int price;

    @Column(name ="describie", nullable = false, length = 100)
    private String des;

    @CreationTimestamp
    private Timestamp userSignupTime;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDes(String des) {
        this.des = des;
    }



}

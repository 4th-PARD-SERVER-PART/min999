package com.assignment.assignment3.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MenuDto {

    private String bname;
    private int price;
    private String description;//설명이에용
    private Long menuId;

}

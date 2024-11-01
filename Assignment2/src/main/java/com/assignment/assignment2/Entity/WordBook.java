package com.assignment.assignment2.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WordBook {
    private Long num;
    private String word;
    private String korean;
    private String star;


    public void updatenum(Long updatenum){
        this.num = updatenum;
    }
    public void updateword(String updateword){
        this.word = updateword;
    }
    public void updaterkorean(String updaterkorean){
        this.korean = updaterkorean;
    }
    public void updaterstar(String updaterstar){
        this.star = updaterstar;
    }
}





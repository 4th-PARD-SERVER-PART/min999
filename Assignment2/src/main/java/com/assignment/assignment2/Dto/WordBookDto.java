package com.assignment.assignment2.Dto;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WordBookDto {
    private String word;
    private String korean;
    private String star;
    private Long num;
}

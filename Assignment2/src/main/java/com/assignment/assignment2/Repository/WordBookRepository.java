package com.assignment.assignment2.Repository;

import com.assignment.assignment2.Dto.WordBookDto;
import com.assignment.assignment2.Entity.WordBook; //Map에서 사용

import org.apache.tomcat.util.http.parser.TokenList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//Repository에서 구현한다
public class WordBookRepository {

    private static final Map<Long, WordBook> WordMap = new HashMap<>();

    public void Save(WordBookDto wordBookDto) {
        WordBook wordBook = WordBook.builder()
                .num(wordBookDto.getNum())
                .word(wordBookDto.getWord())
                .korean(wordBookDto.getKorean())
                .star(wordBookDto.getStar())
                .build();
        WordMap.put(wordBookDto.getNum(),wordBook);

        System.out.println("WordMap 내용: " + WordMap); //로그 확인
    }

    public List<WordBookDto> findAll() {
        return WordMap.values().stream()
           .map(wordBook -> WordBookDto.builder()
                    .num(wordBook.getNum())
                    .word(wordBook.getWord())
                    .korean(wordBook.getKorean())
                    .star(wordBook.getStar())
                    .build()).toList();
    }

    public void delete(Long num){
        WordMap.remove(num);
    }

    public void update(Long num, WordBookDto wordBookDto) {
        WordBook wordBook = WordMap.get(num); //해당 객체 찾고
        wordBook.updatenum(wordBookDto.getNum());
        wordBook.updateword(wordBookDto.getWord());
        wordBook.updaterkorean(wordBookDto.getKorean());
        wordBook.updaterstar(wordBookDto.getStar());
    }

    public WordBookDto findByNum(Long num) {
        WordBook wordBook = WordMap.get(num); //해당 객체 찾고
        //Dto변환필요
        return WordBookDto.builder()
                .word(wordBook.getWord())
                .num(wordBook.getNum())
                .korean(wordBook.getKorean())
                .star(wordBook.getStar())
                .build();
    }
}




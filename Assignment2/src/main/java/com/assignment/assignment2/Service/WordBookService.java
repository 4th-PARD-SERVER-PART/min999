package com.assignment.assignment2.Service;


import com.assignment.assignment2.Dto.WordBookDto;
import com.assignment.assignment2.Repository.WordBookRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor//final 생성자

public class WordBookService {
    private final WordBookRepository wordBookRepository;

    public void Save(WordBookDto wordBookDto) {
        wordBookRepository.Save(wordBookDto);
    }

    public List<WordBookDto> findAll(){

        return wordBookRepository.findAll();
    }

    public void delete (Long num){
        wordBookRepository.delete(num);
    }

    public void update (Long num, WordBookDto wordBookDto) {
        wordBookRepository.update(num, wordBookDto);
    }

    public WordBookDto findByNum(Long num){
        return wordBookRepository.findByNum(num);
    }

}

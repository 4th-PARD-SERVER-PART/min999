package com.assignment.assignment2.Controller;


import com.assignment.assignment2.Dto.WordBookDto;
import com.assignment.assignment2.Service.WordBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word")
public class WordBookController {

    private final WordBookService wordBookService;

    @PostMapping("")
    public String Save(@RequestBody WordBookDto wordBookDto) {
        wordBookService.Save(wordBookDto);
        return "저장완료";
    }

    @GetMapping("")
    public List<WordBookDto> findAll() {
        return wordBookService.findAll();
    }

    @GetMapping("/{num}")
    public WordBookDto findByNum(@PathVariable Long num) {
        return wordBookService.findByNum(num);
    }

    @DeleteMapping("/{num}")
    public String delete(@PathVariable Long num) {
        wordBookService.delete(num);
        return "삭제 되었음";
    }

    @PatchMapping("/{num}")
    public String update(@PathVariable Long num, @RequestBody WordBookDto wordBookDto) {
        wordBookService.update(num, wordBookDto);
        return "업데이트 됨";
    }



}

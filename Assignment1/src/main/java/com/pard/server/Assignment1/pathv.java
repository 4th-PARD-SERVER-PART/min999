package com.pard.server.Assignment1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pathv {


    @RequestMapping("/path/{name}")
    public String path(@PathVariable String name){
        return "이렇게 변수를 받아 와서 돌려줄 수 있다 " + name;
    }



}

package com.pard.server.Assignment1.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstPageController {
    @RequestMapping("/page")
    public String hello(){
        return "FirstPage.html";
    }
}
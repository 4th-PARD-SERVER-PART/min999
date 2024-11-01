package com.assignment.seminar5;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//restcontroller해도 되긴함
//controler가 하위버전

@Controller
public class LoginController {

    @GetMapping("/loginForm")
    public String login() {

        return "loginForm";
    }



}

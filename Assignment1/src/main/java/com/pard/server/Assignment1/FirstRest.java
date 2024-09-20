package com.pard.server.Assignment1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRest {
    @RequestMapping("/request")
    public String requset() {
        return "request";
    }
}

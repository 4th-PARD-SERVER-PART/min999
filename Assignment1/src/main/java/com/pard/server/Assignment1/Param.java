package com.pard.server.Assignment1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Param {

    @RequestMapping("v1")
    public String param1(
            @RequestParam(required = true,defaultValue = "파드") String name,
            @RequestParam(required = false,defaultValue = "-1") Integer age){
        return "RequestParam 5번 : " + name + " 나이 "+ age;
    }

}

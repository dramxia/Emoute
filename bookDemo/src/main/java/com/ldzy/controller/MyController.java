package com.ldzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
    @RequestMapping("/abc")
    public String abc(){
        System.out.println("abc");
        return "index";
    }



//    @RequestMapping("/css/style.css")
//    public String getccs(){
//        System.out.println("abc");
//        return "index";
//    }

}

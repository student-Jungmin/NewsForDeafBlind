package com.ssuOpensource.NewForBlind.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blindnews")
public class NewsController {

    @GetMapping
    public String test(){

        return "test";
    }
}

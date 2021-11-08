package com.ssuOpensource.NewForBlind.controller;

import com.ssuOpensource.NewForBlind.common.NewsSearching;
import com.ssuOpensource.NewForBlind.domain.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;

@Controller
@RequestMapping("blindnews")
public class NewsController {

    @GetMapping("home")
    public String home(){
        return "index";
    }

    @GetMapping("/politics")
    public String sportsNews(Model model){

        LinkedList<News> news = new LinkedList<News>();

        NewsSearching newsSearching = new NewsSearching();

        String category = "100";
        try{
            LinkedList<News> newsList = newsSearching.newsSearch(category);
            for(int i=0; i<10; i++){
                System.out.println(newsList.get(i).getTopic());
                System.out.println("-------------------------------------");
                System.out.println(newsList.get(i).getWritings());
                System.out.println("----------------------------------------");
            }

        }
        catch(Exception e){
            System.out.println("bug");
        }

        return "test";
    }
}

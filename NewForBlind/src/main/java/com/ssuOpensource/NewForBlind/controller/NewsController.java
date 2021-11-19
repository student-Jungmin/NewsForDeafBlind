package com.ssuOpensource.NewForBlind.controller;

import com.ssuOpensource.NewForBlind.common.NewsSearching;
import com.ssuOpensource.NewForBlind.domain.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssuOpensource.NewForBlind.common.makeSound;

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

            for(int i=0; i<1; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic();
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());
                System.out.println(voiceNewsTopicWritings);

                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/policy.mp3",
                        voiceNewsTopicWritings).makeTTS();
            }
        }
        catch(Exception e){
            System.out.println("bug");
        }

        return "index";
    }
}

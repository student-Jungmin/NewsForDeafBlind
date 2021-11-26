package com.ssuOpensource.NewForBlind.controller;

import com.ssuOpensource.NewForBlind.common.NewsSearching;
import com.ssuOpensource.NewForBlind.domain.News;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssuOpensource.NewForBlind.common.makeSound;

import java.io.IOException;
import java.util.LinkedList;

@Controller
@RequestMapping("blindnews")

public class NewsController {

    @GetMapping("home")
    public String home(){
        return "index";
    }

//    @Scheduled(cron = "0 0/59 * * *")
    @GetMapping("/politics")
    public String policyNews(Model model){

        String category = "section_politics";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());
                System.out.println(voiceNewsTopicWritings);

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/policy/policy" + i + ".mp3";
                System.out.println(path);
                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();
            }
        }
        catch(Exception e){
            System.out.println("bug");
            return "index";
        }

        return "index";
    }

//    @Scheduled(cron = "0 0/59 * * *")
    @GetMapping("/economics")
    public String economicNews(Model model){

        String category = "section_economy";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());
                System.out.println(voiceNewsTopicWritings);

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/economy/economy" + i + ".mp3";
                System.out.println(path);
                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();
            }
        }
        catch(Exception e){
            System.out.println("bug");

            return "index";
        }
        return "index";
    }

    @GetMapping("/social")
    public String socialNews(Model model){

        String category = "section_society";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());
                System.out.println(voiceNewsTopicWritings);

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/social/social" + i + ".mp3";
                System.out.println(path);
                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();
            }
        }
        catch(Exception e){
            System.out.println("bug");

            return "index";
        }
        return "index";
    }

    @Scheduled(cron = "*/30*****")
    public String worldNews(Model model){
        System.out.println("111");
        String category = "section_world";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());
                System.out.println(voiceNewsTopicWritings);

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/world/world" + i + ".mp3";
                System.out.println(path);
                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();
            }
        }
        catch(Exception e){
            System.out.println("bug");

            return "index";
        }
        return "index";
    }
}
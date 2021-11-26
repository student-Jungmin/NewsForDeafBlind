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

    @Scheduled(cron = "0 0/59 * * * *")
    public String policyNews(){

        String category = "section_politics";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/policy/policy" + i + ".mp3";
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

    @Scheduled(cron = "0 0/59 * * * *")
    public String economicNews(){

        String category = "section_economy";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/economy/economy" + i + ".mp3";
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

    @Scheduled(cron = "0 0/59 * * * *")
    public String socialNews(){

        String category = "section_society";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/social/social" + i + ".mp3";
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

    // 보여 주기 위한 함수. 15초에 한 번 씩 뉴스 음성 파일을 바꿔 줌
//    @Scheduled(cron = "*/15 * * * * *")
    public String worldNews(){
        System.out.println("크롤링 시작");
        String category = "section_world";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());

                String path = "src/main/java/com/ssuOpensource/NewForBlind/voiceFiles/world/world" + i + ".mp3";

                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();
            }
        }
        catch(Exception e){
            System.out.println("bug");

            return "index";
        }
        System.out.println("크롤링 끝");
        return "index";
    }
}
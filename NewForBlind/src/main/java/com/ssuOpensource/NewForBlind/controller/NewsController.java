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
    public void policyNews(Model model){

        LinkedList<News> news = new LinkedList<News>();

        NewsSearching newsSearching = new NewsSearching();


        String category = "100";
        try{
            LinkedList<News> newsList = newsSearching.newsSearch(category);

            for(int i=0; i<10; i++) {

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
        }
    }

    @GetMapping("/economics")
    public void economicNews(Model model){

        LinkedList<News> news = new LinkedList<News>();

        NewsSearching newsSearching = new NewsSearching();


        String category = "101";
        try{
            LinkedList<News> newsList = newsSearching.newsSearch(category);

            for(int i=0; i<10; i++) {

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
        }
    }

    @GetMapping("/social")
    public void socialNews(Model model){

        LinkedList<News> news = new LinkedList<News>();

        NewsSearching newsSearching = new NewsSearching();


        String category = "102";
        try{
            LinkedList<News> newsList = newsSearching.newsSearch(category);

            for(int i=0; i<10; i++) {

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
        }
    }

    @GetMapping("/world")
    public void worldNews(Model model){

        LinkedList<News> news = new LinkedList<News>();

        NewsSearching newsSearching = new NewsSearching();


        String category = "104";
        try{
            LinkedList<News> newsList = newsSearching.newsSearch(category);

            for(int i=0; i<10; i++) {

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
        }
    }
}

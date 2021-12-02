package com.ssuOpensource.NewForBlind.controller;

import com.ssuOpensource.NewForBlind.common.HtoB;
import com.ssuOpensource.NewForBlind.common.NewsSearching;
import com.ssuOpensource.NewForBlind.domain.News;
import org.json.simple.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssuOpensource.NewForBlind.common.makeSound;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Controller
@RequestMapping("blindnews")

public class NewsController {

    @GetMapping("home")
    public String home(){
        return "index.html";
    }

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH", Locale.KOREA);
    String today = sdf.format(date);

    private static final String crawling_function = "https://github.com/TwoJJung/NewsForDeafBlind/blob/master/NewForBlind/src/main/java/com/ssuOpensource/NewForBlind/common/NewsSearching.java";
    private static final String translate_rules = "https://github.com/TwoJJung/NewsForDeafBlind/blob/master/NewForBlind/src/main/java/com/ssuOpensource/NewForBlind/common/Hash.java";
    private static final String translate_function = "https://github.com/TwoJJung/NewsForDeafBlind/blob/master/NewForBlind/src/main/java/com/ssuOpensource/NewForBlind/common/HtoB.java";

    @Scheduled(cron = "0 0/59 * * * *")
    public String policyNews(){
        String category = "section_politics";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {
                /*
                    encoding
                    title
                    topic
                    date
                    url
                    crawling-function
                    translate-rules
                    translate-function
                    ===
                    original-version
                    translated-version
                    */
                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());
                String NewsWritings = newsList.get(i).getWritings();
                String url = newsList.get(i).getUrl();
                HtoB htoB = new HtoB();
                String jumjaNewsWritings = htoB.H2B(NewsWritings);

                JSONObject header = new JSONObject();
                JSONObject body = new JSONObject();
                JSONObject braileNewsJSON = new JSONObject();

                header.put("encoding", "UTF-8");
                header.put("title", voiceNewsTopic);
                header.put("topic", "policy");
                header.put("date", today);
                header.put("url", url);
                header.put("crawling-function", crawling_function);
                header.put("translate-rules", translate_rules);
                header.put("translate-function", translate_function);

                body.put("original-version", NewsWritings);
                body.put("translated-version", jumjaNewsWritings);

                braileNewsJSON.put("header", header);
                braileNewsJSON.put("body", body);

                String path = "src/main/resources/static/policy/policy" + i + ".mp3";
                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();


                FileWriter jsonfile = new FileWriter("src/main/resources/static/policy_json/policy-" + i);
                jsonfile.write(braileNewsJSON.toJSONString());
                jsonfile.flush();
                jsonfile.close();
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


                String NewsWritings = newsList.get(i).getWritings();
                String url = newsList.get(i).getUrl();
                HtoB htoB = new HtoB();
                String jumjaNewsWritings = htoB.H2B(NewsWritings);

                JSONObject header = new JSONObject();
                JSONObject body = new JSONObject();
                JSONObject braileNewsJSON = new JSONObject();

                header.put("encoding", "UTF-8");
                header.put("title", voiceNewsTopic);
                header.put("topic", "policy");
                header.put("date", today);
                header.put("url", url);
                header.put("crawling-function", crawling_function);
                header.put("translate-rules", translate_rules);
                header.put("translate-function", translate_function);

                body.put("original-version", NewsWritings);
                body.put("translated-version", jumjaNewsWritings);

                braileNewsJSON.put("header", header);
                braileNewsJSON.put("body", body);



                String path = "src/main/resources/static/economy/economy" + i + ".mp3";
                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();


                FileWriter jsonfile = new FileWriter("src/main/resources/static/economy_json/economy-" + i);
                jsonfile.write(braileNewsJSON.toJSONString());
                jsonfile.flush();
                jsonfile.close();
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


                String NewsWritings = newsList.get(i).getWritings();
                String url = newsList.get(i).getUrl();
                HtoB htoB = new HtoB();
                String jumjaNewsWritings = htoB.H2B(NewsWritings);

                JSONObject header = new JSONObject();
                JSONObject body = new JSONObject();
                JSONObject braileNewsJSON = new JSONObject();

                header.put("encoding", "UTF-8");
                header.put("title", voiceNewsTopic);
                header.put("topic", "policy");
                header.put("date", today);
                header.put("url", url);
                header.put("crawling-function", crawling_function);
                header.put("translate-rules", translate_rules);
                header.put("translate-function", translate_function);

                body.put("original-version", NewsWritings);
                body.put("translated-version", jumjaNewsWritings);

                braileNewsJSON.put("header", header);
                braileNewsJSON.put("body", body);


                String path = "src/main/resources/static/social/social" + i + ".mp3";
                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();

                FileWriter jsonfile = new FileWriter("src/main/resources/static/social_json/social-" + i);
                jsonfile.write(braileNewsJSON.toJSONString());
                jsonfile.flush();
                jsonfile.close();

            }
        }
        catch(Exception e){
            System.out.println("bug");

            return "index";
        }
        return "index";
    }

    // 보여 주기 위한 함수. 15초에 한 번 씩 뉴스 음성 파일을 바꿔 줌
    @Scheduled(cron = "*/15 * * * * *")
    public String worldNews(){


        System.out.println("크롤링 시작");
        String category = "section_world";
        try{
            LinkedList<News> newsList = NewsSearching.newsSearch2(category);

            for(int i=0; i<5; i++) {

                String voiceNewsTopic = newsList.get(i).getTopic().concat(". \n\n");
                String voiceNewsTopicWritings = voiceNewsTopic.concat(newsList.get(i).getWritings());


                String NewsWritings = newsList.get(i).getWritings();
                String url = newsList.get(i).getUrl();
                HtoB htoB = new HtoB();
                String jumjaNewsWritings = htoB.H2B(NewsWritings);

                JSONObject header = new JSONObject();
                JSONObject body = new JSONObject();
                JSONObject braileNewsJSON = new JSONObject();

                header.put("encoding", "UTF-8");
                header.put("title", voiceNewsTopic);
                header.put("topic", "policy");
                header.put("date", today);
                header.put("url", url);
                header.put("crawling-function", crawling_function);
                header.put("translate-rules", translate_rules);
                header.put("translate-function", translate_function);

                body.put("original-version", NewsWritings);
                body.put("translated-version", jumjaNewsWritings);

                braileNewsJSON.put("header", header);
                braileNewsJSON.put("body", body);


                String path = "src/main/resources/static/world/world" + i + ".mp3";

                new makeSound("9ccdfcd870e24163a3478032a26e2087",
                        path,
                        voiceNewsTopicWritings).makeTTS();

                FileWriter jsonfile = new FileWriter("src/main/resources/static/world_json/world-" + i);
                jsonfile.write(braileNewsJSON.toJSONString());
                jsonfile.flush();
                jsonfile.close();

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
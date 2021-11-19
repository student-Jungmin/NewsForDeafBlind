package com.ssuOpensource.NewForBlind.controller;

import com.ssuOpensource.NewForBlind.common.NewsSearching;
import com.ssuOpensource.NewForBlind.domain.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssuOpensource.NewForBlind.common.makeSound;
import java.util.LinkedList;
import java.util.Queue;

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

        // 임시 //

//        System.out.println("여기부터 ");
//        HtoB htoB = new HtoB();
//
////        Queue<Integer[]> test = htoB.H2B("안녕하세요 ");
////        htoB.showQueue(test);
//
//        System.out.println("여기까지");

        // 끝 ..

        String category = "100";
        try{
            LinkedList<News> newsList = newsSearching.newsSearch(category);

            for(int i=0; i<10; i++){

//                Queue<Integer[]> jumjatopic = htoB.H2B(newsList.get(i).getTopic());
//                htoB.showQueue(jumjatopic);
//
//                System.out.println("-------------------------");
//                Queue<Integer[]> jumjawritings = htoB.H2B(newsList.get(i).getWritings());
//                htoB.showQueue(jumjawritings);
//                System.out.println("---------------------------");

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

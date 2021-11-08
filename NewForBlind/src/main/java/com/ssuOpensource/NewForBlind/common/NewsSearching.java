package com.ssuOpensource.NewForBlind.common;
import com.ssuOpensource.NewForBlind.domain.News;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

public class NewsSearching {

    public LinkedList<News> newsSearch(String category) throws IOException{
    // 기사 주제 크롤링 시작

    LinkedList<News> news = new LinkedList<News>();

    String url = "https://news.naver.com/main/list.naver?mode=LSD&mid=sec&sid1=" + category;
    Jsoup.connect(url);
    Document doc = Jsoup.connect(url).get();
    Elements elements = doc.getElementsByAttributeValue("class", "list_body newsflash_body");
    Element element = elements.get(0);
    Elements photoElements = element.getElementsByAttributeValue("class", "photo");

        //for(int i =0; i< photoElements.size(); i++)
        for(int i =0; i< 10; i++){
        Element articleElement = photoElements.get(i);
        Elements aElements = articleElement.select("a");
        Element aElement = aElements.get(0);

        String articleUrl = aElements.attr("href"); // 기사링크

        Element imgElement = aElement.select("img").get(0);

//             String imgUrl = imgElement.attr("src"); // 사진링크

        String title = imgElement.attr("alt"); // 기사제목

        Document subDoc = Jsoup.connect(articleUrl).get();
        Element contentElement = subDoc.getElementById("articleBodyContents");
        String content = contentElement.text(); // 기사내용

//        System.out.println(title);
//        System.out.println(articleUrl);
//        System.out.println(content);
//        System.out.println("\n");

        news.add(new News(title,content));
    }

    return news;
    // 기사 주제 크롤링 끝


    //기사 url로 크롤링
//        String url = //"https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=100&oid=629&aid=0000108261";
//        Jsoup.connect(url);
//        Document doc = Jsoup.connect(url).get();
//        Element contentElement = doc.getElementById("articleBodyContents");
//        String content = contentElement.text(); // 기사내용
//
//
//        System.out.println("=========================");
//        System.out.println(content);
//        System.out.println("=========================");
//기사 url로 크롤링 끝




    // 기사제목, 기사 url, 사진, 기사내용

//        System.out.println("====================");
//        System.out.println(elements.size());
    }
}


package com.ssuOpensource.NewForBlind.common;
import com.ssuOpensource.NewForBlind.domain.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.LinkedList;

public class NewsSearching {

    public LinkedList<News> newsSearch(String category) throws IOException{
    // 기사 주제 크롤링 시작

    LinkedList<News> news = new LinkedList<News>();

    String url = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=" + category;
    Jsoup.connect(url);
    Document doc = Jsoup.connect(url).get();
    Elements elements = doc.getElementsByAttributeValue("class", "cluster_group _cluster_content");
    Element element = elements.get(0);
    Elements photoElements = element.getElementsByAttributeValue("class", "photo");

        for(int i =0; i< 10; i++){
        Element articleElement = photoElements.get(i);
        Elements aElements = articleElement.select("a");
        Element aElement = aElements.get(0);

        String articleUrl = aElements.attr("href"); // 기사링크
        Element imgElement = aElement.select("img").get(0);

        String title = imgElement.attr("alt"); // 기사제목

        Document subDoc = Jsoup.connect(articleUrl).get();
        Element contentElement = subDoc.getElementById("articleBodyContents");
        String content = contentElement.text(); // 기사내용


        news.add(new News(title,content,articleUrl));
    }

    return news;
    }

    public static LinkedList<News> newsSearch2(String category) throws IOException{
        LinkedList<News> news = new LinkedList<News>();
        String url = "https://news.naver.com/main/home.naver";
        Jsoup.connect(url);

        Document doc = Jsoup.connect(url).get();

        Element elementById = doc.getElementById(category);
        Elements liElements = elementById.getElementsByTag("li");

        for(int i=0; i<5; i++) {
            Element fullArticleTitle = liElements.get(i);
            String textFullArticleTitle = fullArticleTitle.text();
            String videoArticleTitle = textFullArticleTitle.toString().split("포토")[0];

            String articleTitle = videoArticleTitle.split("동영상")[0]; // 기사제목

            Elements li = fullArticleTitle.getElementsByTag("li");

            Elements a = li.select("a");
            String s = a.toString();
            String[] split = s.split("\"");
            String articleUrl = split[1].replace("amp;", "");

            Document subDoc = Jsoup.connect(articleUrl).get();
            Element contentElement = subDoc.getElementById("articleBodyContents");
            String content = contentElement.text(); // 기사내용

            System.out.println(articleTitle);
            System.out.println(articleUrl);
            System.out.println(content);
            news.add(new News(articleTitle,content,articleUrl));
        }
        return news;
    }

}


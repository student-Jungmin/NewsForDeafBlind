package com.ssuOpensource.NewForBlind.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News {

    public News(){}

    public News(String topic, String writings){
        this.topic = topic;
        this.writings = writings;
    }

    private String id;

    private String topic;

    private String writings;

}

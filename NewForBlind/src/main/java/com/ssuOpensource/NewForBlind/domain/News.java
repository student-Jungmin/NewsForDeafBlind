package com.ssuOpensource.NewForBlind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class News {

    public News(){}

    public News(String topic, String writings){
        this.topic = topic;
        this.writings = writings;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String topic;

    @Column
    private String writings;

}

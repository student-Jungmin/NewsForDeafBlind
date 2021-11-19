package com.ssuOpensource.NewForBlind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ssuOpensource.NewForBlind"})
public class NewForBlindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewForBlindApplication.class, args);
	}

}

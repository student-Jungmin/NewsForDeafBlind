package com.ssuOpensource.NewForBlind.common;

/**********************************************
 *    voiceRss에서 sdk library 사용해야 작동     *
 **********************************************/

public class msExample {
    public static void main(String[] args) {
        makeSound mss = new makeSound (
                "9ccdfcd870e24163a3478032a26e2087",             //apikey
                "./audioFiles/test.mp3",                         //Filepath
                makeSound.test);                                //내용 (string)

        mss.makeTTS();
    }
}
package com.ssuOpensource.NewForBlind.common.HtoB.src;

import java.io.*;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.String;

/*  약어나 파일입출력은 아직 구현되지 않았으며
한글을 자모음, 키 값으로 변환하는것까지만 구현됨
해쉬태이블을 구현한 뒤에 키 -> 점자를 구현하는것이 바람직해보임  */

//HtoB 객체 생성후 H2B(string) 으로 결과확인가능
public class HtoB {
    String outfile;
    String input;

    public HtoB(String outfile, String input){
        this.outfile = outfile;
        this.input = input;
    }


    public void H2B()       //이후 입력 파일로 인자를 변경할 예정
    {
        try {

            FileWriter fw = new FileWriter(outfile);
            BufferedWriter bw = new BufferedWriter(fw);

            HashMap<Integer, Integer> hash = new Hash().makeHash();
            Queue<Integer[]> q = new LinkedList<>();   //자모 분리한 한글을 큐에 저장함

            for (int i = 0; i < input.length(); i++)
                q.offer(separation(input.charAt(i)));

            makeJJ(q, hash, bw);

            bw.flush();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int word_past;
    private Integer[] separation(char input)    //자모 분리 함수
    {
        int s, m, e;    //word를 넣는 방식은 환경에 따라 결과가 변할 것 같아서 다른방법 공부중임

        //나머지는 초성, 중성, 종성을 담을 변수들

        if(input >= 0x30 && input <= 0x39) {
            Integer[] arr;
            if(word_past >= 30 && word_past <= 39) {
                arr = new Integer[]{9, input + 30, 40};
            }
            else{
                arr = new Integer[]{input + 30, 40, 40};
            }
            return arr;
        }

        if((input >= 0x41 && input <= 0x5A) || (input >= 0x61 && input <= 0x7A)){
            if((word_past >= 0x41 && word_past <= 0x5A) || (word_past >= 0x61 && word_past <= 0x7A))
                ;
        }

        s = (input - 0xAC00)/(21 * 28);                      //한글을 각각 자모음 인덱스로 변환
        m = (input - 0xAC00 - (s * 21 * 28)) / 28;
        e = input - 0xAC00 - (s * 21 * 28) - (m * 28);

        m += 19;
        e += 19 + 21;

        Integer[] arr = {s, m, e};
        word_past = input;

        return arr;
    }

    private void makeJJ(Queue<Integer[]> q, HashMap<Integer, Integer> hash, BufferedWriter bw) throws Exception {
        Integer[] value = q.poll();

        while (value != null) {
            for(int i = 0; i < 3; i++)
                bw.write(0x2800 + hash.get(value[i]));
            value = q.poll();
        }
    }
}
package com.ssuOpensource.NewForBlind.common;

import java.util.Queue;
import java.util.LinkedList;
import java.lang.String;

/*  약어나 파일입출력은 아직 구현되지 않았으며
한글을 자모음, 키 값으로 변환하는것까지만 구현됨
해쉬태이블을 구현한 뒤에 키 -> 점자를 구현하는것이 바람직해보임  */

//HtoB 객체 생성후 H2B(string) 으로 결과확인가능
public class HtoB
{

    public HtoB(){
    }
    public Queue<Integer[]> H2B(String input)       //이후 입력 파일로 인자를 변경할 예정
    {
        Queue<Integer[]> q = new LinkedList<>();   //자모 분리한 한글을 큐에 저장함

        for(int i = 0; i < input.length(); i++)
        {
            q.offer(separation(input.charAt(i)));
        }
        showQueue(q);
        return q;      //이후 경우에 따라 리턴하지않고 바로 파일에 출력할 예정
    }

    private Integer[] separation(char input)    //자모 분리 함수
    {
        int word = input, s, m, e;    //word를 넣는 방식은 환경에 따라 결과가 변할 것 같아서 다른방법 공부중임
        //나머지는 초성, 중성, 종성을 담을 변수들

        s = (word - 0xAC00)/(21 * 28);                      //한글을 각각 자모음 인덱스로 변환
        m = (word - 0xAC00 - (s * 21 * 28)) / 28;
        e = word - 0xAC00 - (s * 21 * 28) - (m * 28);

        s += 0x1100;                                    //인덱스에 자모음이 위치한 유니코드를 더함(필요없을수도있음)
        m += 0x1161;
        e += 0x11A7;

        if(e == 0x11A7)
            e = ' ';

        Integer[] arr = {s, m, e};
        return arr;
    }

    public static boolean SETMODE = true;   //16진수 결과값으로 보고 싶으면 false
    public void showQueue(Queue<Integer[]> queue)    //결과확인용 임시메소드
    {
        if(SETMODE)
        {
            Integer[] value = queue.poll();
            while (value != null)
            {
                System.out.printf("%c %c %c\n", value[0], value[1], value[2]);
                value = queue.poll();
            }
        }
        else
        {
            Integer[] value = queue.poll();
            while (value != null)
            {
                System.out.printf("%X %X %X\n", value[0], value[1], value[2]);
                value = queue.poll();
            }
        }
    }
}

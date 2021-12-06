package com.ssuOpensource.NewForBlind.common;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.String;

public class HtoB {

    String input;

    public HtoB(){
    }


    public String H2B(String input)       //이후 입력 파일로 인자를 변경할 예정
    {
        StringBuffer output = new StringBuffer();
        this.input = input;

        HashMap<Integer, Integer> hash = new Hash().makeHash();
        Queue<Integer[]> q = new LinkedList<>();   //자모 분리한 한글을 큐에 저장함

        for (int i = 0; i < input.length(); i++) {
            q.offer(separation(input.charAt(i), q));
            word_past = input.charAt(i);
        }

        makeJJ(q, hash, output);
        return output.toString();
    }

    int word_past;
    private Integer[] separation(char input, Queue<Integer[]> q)    //자모 분리 함수
    {
        int s, m, e;

        if(input >= 0x30 && input <= 0x39) {
            if(!(word_past >= 0x30 && word_past <= 0x39)) {
                return new Integer[]{77, input + 30, 40};
            }
            else{
                return new Integer[]{input + 30, 40, 40};
            }
        }

        else if(input >= 0x41 && input <= 0x5A) {
            if (!((word_past >= 0x41 && word_past <= 0x5A) || (word_past >= 0x61 && word_past <= 0x7A)))
                return new Integer[]{67, 9, input + 30};
            else
                return new Integer[]{9, input + 30, 40};
        }

        else if(input >= 0x61 && input <= 0x7A) {
            if (!((word_past >= 0x41 && word_past <= 0x5A) || (word_past >= 0x61 && word_past <= 0x7A)))
                return new Integer[]{67, input - 2, 40};
            else
                return new Integer[]{input - 2, 40, 40};
        }

        else if(input >= 0xAC00 && input <= 0xD7AF) {
            int[] ss = {1, 4, 8, 10, 13};

            s = (input - 0xAC00) / (21 * 28);                      //한글을 각각 자모음 인덱스로 변환
            for (int tmp: ss)  {
                if(tmp == s) {
                    q.offer(new Integer[]{9, 40, 40});
                    s -= 1;
                }
            }

            m = (input - 0xAC00 - (s * 21 * 28)) / 28;
            e = input - 0xAC00 - (s * 21 * 28) - (m * 28);

            m += 19;
            e += 19 + 21;

            q.offer(new Integer[]{s, m, e});
            return jongsung(e);
        }
        else
            return new Integer[]{40, 40, 40};
    }

    private Integer[] jongsung(int e) {
        switch (e) {
            case 49:
            case 42:
                return new Integer[]{41, 40, 40};
            case 52:
            case 43:
                return new Integer[]{59, 40, 40};
            case 45:
                return new Integer[]{62, 40, 40};
            case 55:
            case 46:
                return new Integer[]{67, 40, 40};
            case 50:
                return new Integer[]{56, 40, 40};
            case 51:
                return new Integer[]{57, 40, 40};
            case 53:
                return new Integer[]{65, 40, 40};
            case 54:
                return new Integer[]{66, 40, 40};
        }
        return new Integer[]{40, 40, 40};
    }

    private void makeJJ(Queue<Integer[]> q, HashMap<Integer, Integer> hash, StringBuffer output) {
        Integer[] value = q.poll();
        int j, i = -1;

        try {
            while (value != null) {
                for (i = 0; i < 3; i++) {
                    j = 0x2800 + hash.get(value[i]);
                    if (j == 0x2800)
                        j = 0x200B;
                    output.append((char) j);
                }
                value = q.poll();
            }
        } catch (NullPointerException e) {
            System.out.printf("EXCEPTION i = %d value[%d] = %d\n", i, i, value[i]);
        }
    }
}

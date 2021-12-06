package com.ssuOpensource.NewForBlind.common;

import java.util.HashMap;
public class Hash {
    public HashMap<Integer, Integer> makeHash()
    {
        HashMap<Integer, Integer> map = new HashMap<>(121);

        //된소리는 ㅅ, 32 앞에 먼저 쓰기
        map.put(0, 8);
        map.put(2, 9);
        map.put(3, 10);
        map.put(5, 16);
        map.put(6, 17);
        map.put(7, 24);
        map.put(9, 32);
        map.put(11, 0);
        map.put(12, 40);
        map.put(14, 48);
        map.put(15, 11);
        map.put(16, 19);
        map.put(17, 25);
        map.put(18, 26);        //자음

        map.put(19, 35);
        map.put(20, 23);
        map.put(21, 28);
        map.put(22, 23);
        map.put(23, 14);
        map.put(24, 29);
        map.put(25, 49);
        map.put(26, 12);
        map.put(27, 37);
        map.put(28, 39);
        map.put(29, 39);
        map.put(30, 61);
        map.put(31, 44);
        map.put(32, 13);
        map.put(33, 15);
        map.put(34, 15);
        map.put(35, 13);
        map.put(36, 41);
        map.put(37, 42);
        map.put(38, 58);
        map.put(39, 21);

        map.put(40, 0);     //받침없음
        map.put(41, 1);     //ㄱ
        map.put(42, 8);         //ㄲ
        map.put(43, 0);         //ㄳ
        map.put(44, 18);    //ㄴ
        map.put(45, 18);        //ㄵ
        map.put(46, 18);        //ㄶ
        map.put(47, 20);    //ㄷ
        map.put(48, 2);     //ㄹ
        map.put(49, 2);         //ㄺ
        map.put(50, 2);         //ㄻ
        map.put(51, 2);         //ㄼ
        map.put(52, 2);         //ㄽ
        map.put(53, 2);         //ㄾ
        map.put(54, 2);         //ㄿ
        map.put(55, 2);         //ㅀ
        map.put(56, 34);    //ㅁ
        map.put(57, 3);     //ㅂ
        map.put(58, 3);
        map.put(59, 4);     //ㅅ
        map.put(60, 4);
        map.put(61, 54);    //ㅇ
        map.put(62, 5);     //ㅈ
        map.put(63, 6);     //ㅊ
        map.put(64, 22);    //ㅋ
        map.put(65, 38);    //ㅌ
        map.put(66, 50);    //ㅍ
        map.put(67, 52);    //ㅎ

        map.put(77, 60);
        map.put(78, 26);
        map.put(79, 1);
        map.put(80, 3);
        map.put(81, 9);
        map.put(82, 25);
        map.put(83, 17);
        map.put(84, 11);
        map.put(85, 27);
        map.put(86, 19);
        map.put(87, 10);

        map.put(95, 1);
        map.put(96, 3);
        map.put(97, 9);
        map.put(98, 25);
        map.put(99, 17);
        map.put(100, 11);
        map.put(101, 27);
        map.put(102, 19);
        map.put(103, 10);
        map.put(104, 26);
        map.put(105, 5);
        map.put(106, 7);
        map.put(107, 13);
        map.put(108, 29);
        map.put(109, 21);
        map.put(110, 15);
        map.put(111, 31);
        map.put(112, 23);
        map.put(113, 14);
        map.put(114, 30);
        map.put(115, 37);
        map.put(116, 39);
        map.put(117, 58);
        map.put(118, 45);
        map.put(119, 61);
        map.put(120, 53);
        return map;
    }
}


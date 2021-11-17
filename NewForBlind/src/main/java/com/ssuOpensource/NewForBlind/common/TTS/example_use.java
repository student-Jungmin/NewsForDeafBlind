/**********************************************
 *    voiceRss에서 sdk library 사용해야 작동     *
 **********************************************/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class example_use {
    public static void main(String[] args) {
        makeSoundString mss = new makeSoundString("여기에 키 넣기");      //voiceRss 키 넣기
        byte[] b = mss.buildString(makeSoundString.test);
        String str = new String(b, StandardCharsets.ISO_8859_1);          //인코딩

        try {
            BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(                     //테스트 용도 파일에 써보기
                    new FileOutputStream("./audioFiles/test.mp3"), "Cp1252")   //문자열 사용시엔 지우기
            );
            fos.write(str);
            fos.flush();
            fos.close();
        } catch (Exception e) {}
    }
}

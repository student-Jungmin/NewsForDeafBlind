/**********************************************
 *    voiceRss에서 sdk library 사용해야 작동     *
 **********************************************/

public class msExample {
    public static void main(String[] args) {
        makeSound mss = new makeSound (
                "여기에 키를 넣어주세요",                         //apikey
                "./audioFiles/test.mp3",                        //Filepath
                makeSound.test);                                //내용 (string)

        mss.makeTTS();
    }
}

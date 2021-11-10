public class example_use {
    public static void main(String[] args) {
        TextToSpeach test = new TextToSpeach();
        try {
            test.textToSpeach("여기에 키 넣기");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

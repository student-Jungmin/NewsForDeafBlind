public class example_use {
    public static void main(String[] args) {
        TextToSpeach test = new TextToSpeach();
        try {
            test.textToSpeach("8d011ccde2f54638b2c629e02882955c");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

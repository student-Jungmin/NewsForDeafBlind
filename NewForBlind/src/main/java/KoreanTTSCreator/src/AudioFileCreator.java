import com.voicerss.tts.AudioCodec;
import com.voicerss.tts.AudioFormat;
import com.voicerss.tts.VoiceParameters;
import com.voicerss.tts.VoiceProvider;

import java.io.FileOutputStream;
import java.io.IOException;

public class AudioFileCreator
{
    private VoiceProvider tts;
    private String outputFolder;

    AudioFileCreator(String apiKey, String outputFolder)
    {
        this.outputFolder = outputFolder;
        tts = new VoiceProvider(apiKey);
    }

    public void createAudioFile(String fileName, String content, String language)
    {
        String filepath = outputFolder + "/" + fileName + ".mp3";
        VoiceParameters params = new VoiceParameters(content, language);
        params.setCodec(AudioCodec.WAV);
        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(0);


        byte[] voice;
        try {
            voice = tts.speech(params);
        } catch (Exception e) {
            System.out.println("Error: Cannot create tts for " + filepath);
            e.printStackTrace();
            return;
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filepath);
            fos.write(voice, 0, voice.length);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error: Cannot create file " + filepath);
            e.printStackTrace();
        }

        System.out.println("File successfully created :\"" + filepath + "\".");
    }

}

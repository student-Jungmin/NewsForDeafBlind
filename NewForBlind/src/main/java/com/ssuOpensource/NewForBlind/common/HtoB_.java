import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class HtoB
{

    public HtoB(String InputFileName, String OutputFileName)
    {
        infile = InputFileName;
        outfile = OutputFileName;
    }

    public void H2B()
    {
        Queue<Integer[]> q = new LinkedList<>();
        try
        {
            FileReader fileReader = new FileReader(infile);
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outfile, false);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String word;
            while((word = reader.readLine()) != null) 
            {
                String parsed[] = parsing(word);
                int j = 0;
                while(j < parsed.length) 
                {
                    for(int i = 0; i < word.length(); i++)
                        q.offer(separation(word.charAt(i)));

                    writeQueue(q, writer);
                    j++;
                }
            }
            fileReader.close();
            reader.close();
            fileWriter.close();
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("IOEXCEPTION");
        }
    }

    private String[] parsing(String line)
    {
        return line.split(" ");
    }

    private Integer[] separation(char input)
    {
        int word = input;
        if(word == 32)
        {
            Integer[] blank = { 32, 32, 32 };
            return blank;
        }

        int s = (word - 44032) / 588;
        int m = (word - 44032 - s * 21 * 28) / 28;
        int e = word - 44032 - s * 21 * 28 - m * 28;

        s += 4352;

        m += 4449;

        if((e += 4519) == 4519)
            e = 32;

        Integer[] arr = { s, m, e };
        return arr;
    }

    protected void writeQueue(Queue<Integer[]> queue, BufferedWriter writer)
        throws IOException
    {
        for(Integer value[] = queue.poll(); value != null; value = queue.poll())
        {
            Integer[] ch = value;
            int i = ch.length;
            for(int j = 0; j < i; j++)
            {
                writer.write(ch[j]);
            }
            writer.newLine();
        }

        writer.flush();
    }

    String infile;
    String outfile;
}

package mappers;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WikiDumpMapper extends Mapper<Object, Text, Text, IntWritable> {
    private static final IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public static String cleanXmlTags(String xmlText) {
        // remove REDIRECT
        xmlText = xmlText.replaceAll("REDIRECT", " ");

        // removes whole matched foreign characters.
        xmlText = xmlText.replaceAll("([^\\x20-\\x7E]+)", " ");

        // remove ????: from ????:xxxx
        xmlText = xmlText.replaceAll("[a-zA-Z-]+:(\\w*)", "$1 "); // TODO

        xmlText = xmlText.replaceAll("&lt;.+&gt;", " ");

        // remove tags
        xmlText = xmlText.replaceAll("</?.*?>", " ");

        // replace &???;???;... to space
        xmlText = xmlText.replaceAll("&[a-zA-Z;]+;", " ");

        // remove 's
        xmlText = xmlText.replaceAll("'s", " ");

        // remove non-alphanumeric characters and underscore
        xmlText = xmlText.replaceAll("[\\W_]", " ");

        // remove 5+ digits numbers
        xmlText = xmlText.replaceAll("\\d{5,}", " ");

        // remove 1~2 digits numbers
        xmlText = xmlText.replaceAll("\\s\\d{1,2}\\s", " ");

        // remove excessive whitespaces
        xmlText = xmlText.replaceAll("\\s+", " ").trim();

        return xmlText;
    }

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = cleanXmlTags(value.toString());
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            word.set(tokenizer.nextToken());
            context.write(word, one);
        }
    }

}
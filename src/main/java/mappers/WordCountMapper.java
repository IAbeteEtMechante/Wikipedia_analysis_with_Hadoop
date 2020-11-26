/* MapReduce Program - file WordCountMapper.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package mappers;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/** Mapper class for MapReduce program
 * of MostUsedWords.java
 */

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {
    private static final IntWritable one = new IntWritable(1);
    private Text word = new Text();

    /** Map Function
     * Maps every input to record one.
     *
     * @param key is the word from Wikipedia article.
     * @param value is set to one to represent the count of word.
     * @param context is the map containing the words and corresponding value of one.
     * @throws IOException if map cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        // gets the word and assigns its value to one
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            word.set(tokenizer.nextToken());
            context.write(word, one);
        }
    }
}
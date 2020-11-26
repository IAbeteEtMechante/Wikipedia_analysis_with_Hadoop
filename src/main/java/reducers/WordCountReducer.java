/* MapReduce Program - file WordCountReducer.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package reducers;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/** Reducer class for MapReduce program
 * of MostUsedWords.java
 */

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable result = new IntWritable();

    /** Reduce Function
     * Aggregation of results.
     * Outputs the total count of a word in article.
     *
     * @param key is the word from Wikipedia articles.
     * @param values is the sum of count of words in a Wikipedia article.
     * @param context is the map containing summary of data.
     * @throws IOException if reduce cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context) throws IOException, InterruptedException {

        // computes the number of occurrences of a single word
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }

        // puts the number of occurrences of this word into the map.
        // We need to create another Text object because the Text instance
        // we receive is the same for all the words
        result.set(sum);
        context.write(key, result);
    }
}
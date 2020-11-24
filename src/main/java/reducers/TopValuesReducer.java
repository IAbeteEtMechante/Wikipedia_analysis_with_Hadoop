/* MapReduce Program - file TopValuesReducer.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package reducers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import utils.MiscUtils;

/** Reducer class for MapReduce program
 * of MostUsedWords.java
 */

public class TopValuesReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private Map<Text, IntWritable> countMap = new HashMap<>();

    /** Reduce Function
     * Aggregation of results.
     * Outputs the sum of every word used
     * in Wikipedia article.
     *
     * @param key is the word from Wikipedia articles.
     * @param values is the sum of count of words in a Wikipedia article.
     * @param context is the map containing summary of data.
     * @throws IOException if reduce cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {

        // computes the number of occurrences of a single word
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }

        // puts the number of occurrences of this word into the map.
        // We need to create another Text object because the Text instance
        // we receive is the same for all the words
        countMap.put(new Text(key), new IntWritable(sum));
    }

    /** Writes and sort the result of every
     * processed partition.
     *
     * @param context is the map containing the summary of sorted data.
     * @throws IOException if cleanup cannot be closed.
     * @throws InterruptedException if interrupted while processing.
     */

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        Map<Text, IntWritable> sortedMap = MiscUtils.sortByValues(countMap);
        int counter = 0;
        for (Text key : sortedMap.keySet()) {
            if (counter++ == 20) {
                break;
            }
            context.write(key, sortedMap.get(key));
        }
    }
}

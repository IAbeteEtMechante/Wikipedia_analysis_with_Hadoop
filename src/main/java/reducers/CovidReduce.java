/* MapReduce Program - file CovidReduce.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

package reducers;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/** Reducer class for MapReduce program
 * of CovidDriver.java
 */

public class CovidReduce extends Reducer<Text, LongWritable, Text, LongWritable> {

    /** Reduce Function
     * Aggregation of results.
     * Outputs the sum total views of
     * Covid related Wikipedia articles.
     *
     * @param key is the covid related article from Wikipedia.
     * @param values is the view count of Covid related Wikipedia articles.
     * @param context is the map containing summary of data.
     * @throws IOException if reduce cannot be written or closed.
     * @throws InterruptedException if interrupted while processing.
     */

    public void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {

        // returns the total views of Covid related Wikipedia articles
        long views = (long) 0;
        for (LongWritable t : values) {
            views += t.get();
        }
        context.write(key, new LongWritable(views));
    }
}
